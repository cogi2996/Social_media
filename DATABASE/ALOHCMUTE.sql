create schema if not exists ALOHCMUTE;
use ALOHCMUTE;

create table `Account`(
	gmail varchar(100) primary key,
    userName varchar(50) not null,
    password varchar(100) not null
);

-- Tạo bảng User 
create table `User`(
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
    foreign key (gmail) references `Account`(gmail)
);

-- Tạo bảng Group
create table `Group`(
	groupID int primary key,
    groupName nvarchar(100) not null,
    createTime datetime not null,
    createrID int,
    foreign key (createrID) references `User`(userID)
);

-- Tạo bảng Follow
create table `Follow`(
	sourceID int ,
    targetID int,
    fCreateTime datetime not null,
    fUpdateTime datetime not null,
    fStatus boolean not null default 1,
    primary key (sourceID, targetID),
    foreign key (sourceID) references `User`(userID),
    foreign key (targetID) references `User`(userID)
);

-- Tạo bảng BoxChat
create table `BoxChat`(
	bcID int primary key,
    userID int,
    foreign key (userID) references `User`(userID)
);

-- Tạo bảng Chat
create table `Chat`(
	chatID int primary key,
    bcID int,
    foreign key (bcID) references `BoxChat`(bcID)
); 

-- Tạo bảng UserPost
create table `UserPost`(
	upID int primary key,
    userID int,
    upText nvarchar(5000) not null,
    upCreateTime datetime not null,
    upStatus boolean not null default 1,
    upUpdateTime datetime not null,
	foreign key (userID) references `User`(userID)
);

-- Tạo bảng GroupPost
create table `GroupPost`(
	gpID int primary key,
    gpText nvarchar(5000) not null,
    gpCreateTime datetime not null,
    gpStatus boolean not null default 1,
    gpUpdateTime datetime not null
);

-- Tạo bảng GroupMember
create table `GroupMember`(
	groupID int,
    userID int,
    gpID int,
    primary key(groupID, userID, gpID),
	foreign key (groupID) references `Group`(groupID),
	foreign key (userID) references `User`(userID),
    foreign key (gpID) references `GroupPost`(gpID)
);

-- Tạo bảng UserImage
create table `UserImage`(
	uiID int primary key,
    upID int,
    uiFile text not null,
    foreign key (upID) references `UserPost`(upID)
);

-- Tạo bảng GroupImage
create table `GroupImage`(
	giID int primary key,
    gpID int,
    giFile text not null,
	foreign key (gpID) references `GroupPost`(gpID)
);
