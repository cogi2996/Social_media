create schema if not exists ALOHCMUTE;
use ALOHCMUTE;

create table tbAccount(
	gmail varchar(100) primary key,
    userName varchar(50) not null,
    password varchar(100) not null
);

-- Tạo bảng User 
create table tbUser(
	userID int primary key,
    gmail varchar(100),
	mobile varchar(11),
    createDate datetime not null,
    lastLogin datetime not null,
    firstName nvarchar(50) not null,
    midName nvarchar(50),
    lastName nvarchar(50) not null,
    address nvarchar(200),
    biography nvarchar(5000),
    position nvarchar(100),
    workPlace nvarchar(200),
    avatar text,
    cover text,
    foreign key (gmail) references tbAccount(gmail)
);

-- Tạo bảng Group
create table tbGroup(
	groupID int primary key,
    groupName nvarchar(100) not null,
    createTime datetime not null,
    createrID int,
    foreign key (createrID) references tbUser(userID)
);

-- Tạo bảng Follow
create table tbFollow(
	sourceID int ,
    targetID int,
    fCreateTime datetime not null,
    fUpdateTime datetime not null,
    fStatus boolean not null default 1,
    primary key (sourceID, targetID),
    foreign key (sourceID) references tbUser(userID),
    foreign key (targetID) references tbUser(userID)
);

-- Tạo bảng BoxChat
create table tbBoxChat(
	bcID int primary key,
    userID int,
    foreign key (userID) references tbUser(userID)
);

-- Tạo bảng Chat
create table tbChat(
	chatID int primary key,
    bcID int,
    foreign key (bcID) references tbBoxChat(bcID)
); 

-- Tạo bảng UserPost
create table tbUserPost(
	upID int primary key,
    userID int,
    upText nvarchar(5000) not null,
    upCreateTime datetime not null,
    upStatus boolean not null default 1,
    upUpdateTime datetime not null,
	foreign key (userID) references tbUser(userID)
);

-- Tạo bảng GroupPost
create table tbGroupPost(
	gpID int primary key,
    gpText nvarchar(5000) not null,
    gpCreateTime datetime not null,
    gpStatus boolean not null default 1,
    gpUpdateTime datetime not null
);

-- Tạo bảng GroupMember
create table tbGroupMember(
	groupID int,
    userID int,
    gpID int,
    primary key(groupID, userID, gpID),
	foreign key (groupID) references tbGroup(groupID),
	foreign key (userID) references tbUser(userID),
    foreign key (gpID) references tbGroupPost(gpID)
);

-- Tạo bảng UserImage
create table tbUserImage(
	uiID int primary key,
    upID int,
    uiFile text not null,
    foreign key (upID) references tbUserPost(upID)
);

-- Tạo bảng GroupImage
create table tbGroupImage(
	giID int primary key,
    gpID int,
    giFile text not null,
	foreign key (gpID) references tbGroupPost(gpID)
);
