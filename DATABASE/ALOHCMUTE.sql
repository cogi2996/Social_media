create database ALOHCMUTE;
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
    biography nvarchar(3000),
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
    followCreateTime datetime not null,
    followUpdateTime datetime not null,
    followStatus boolean not null default 1,
    primary key (sourceID, targetID),
    foreign key (sourceID) references `User`(userID),
    foreign key (targetID) references `User`(userID)
);

-- Tạo bảng BoxChat
create table `BoxChat`(
	boxChatID int primary key,
    userID int,
    foreign key (userID) references `User`(userID)
);

-- Tạo bảng Chat
create table `Chat`(
	chatID int primary key,
    boxChatID int,
    foreign key (boxChatID) references `BoxChat`(boxChatID)
); 

-- Tạo bảng UserPost
create table `UserPost`(
	userPostID int primary key,
    userID int,
    userPostText nvarchar(5000) not null,
    UserPostCreateTime datetime not null,
    UserPostStatus boolean not null default 1,
    userPostUpdateTime datetime not null,
	foreign key (userID) references `User`(userID)
);

-- Tạo bảng GroupPost
create table `GroupPost`(
	groupPostID int primary key,
    groupPostText nvarchar(5000) not null,
    groupPostCreateTime datetime not null,
    groupPostStatus boolean not null default 1,
    groupPostUpdateTime datetime not null
);

-- Tạo bảng GroupMember
create table `GroupMember`(
	groupID int,
    userID int,
    groupPostID int,
    primary key(groupID, userID, groupPostID),
	foreign key (groupID) references `Group`(groupID),
	foreign key (userID) references `User`(userID),
    foreign key (groupPostID) references `GroupPost`(groupPostID)
);

-- Tạo bảng UserImage
create table `UserImage`(
	userImageID int primary key,
    userPostID int,
    userImageFile text not null,
    foreign key (userPostID) references `UserPost`(userPostID)
);

-- Tạo bảng GroupImage
create table `GroupImage`(
	groupImageID int primary key,
    groupPostID int,
    groupImageFile text not null,
	foreign key (groupPostID) references `GroupPost`(groupPostID)
);
