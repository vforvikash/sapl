USE [SAPL_DB]
GO

/****** Object:  Table [dbo].[USER_TBL]    Script Date: 06/05/2012 18:22:55 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[USER_TBL](
	[USER_ID] [int] IDENTITY(1,1) NOT NULL,
	[USER_LOGIN] [nchar](20) NOT NULL,
	[USER_PASSWORD] [nchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[USER_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

USE [SAPL_DB]
GO

/****** Object:  Table [dbo].[USERROLE_TBL]    Script Date: 06/05/2012 18:23:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[USERROLE_TBL](
	[USERROLE_ID] [int] IDENTITY(1,1) NOT NULL,
	[USER_ID] [int] NOT NULL,
	[USER_ROLE] [nchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[USERROLE_ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[USERROLE_TBL]  WITH CHECK ADD  CONSTRAINT [FK_USER_ROLE] FOREIGN KEY([USER_ID])
REFERENCES [dbo].[USER_TBL] ([USER_ID])
GO

ALTER TABLE [dbo].[USERROLE_TBL] CHECK CONSTRAINT [FK_USER_ROLE]
GO


INSERT INTO `sapl_db`.`role_tbl` (`ROLE`, `DESCRIPTION`) VALUES ('ROLE_ADMIN', 'admistrator');
INSERT INTO `sapl_db`.`role_tbl` (`ROLE`, `DESCRIPTION`) VALUES ('ROLE_USER', 'normal user');


INSERT INTO `sapl_db`.`user_tbl` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES ('1', 'sundip', 'thakur1836');
INSERT INTO `sapl_db`.`user_tbl` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES ('2', 'mintoo', 'mintoo');

INSERT INTO `sapl_db`.`userrole_tbl` (`USERROLE_ID`, `USER_ID`, `USER_ROLE`) VALUES ('1', '1', 'ROLE_ADMIN');
INSERT INTO `sapl_db`.`userrole_tbl` (`USERROLE_ID`, `USER_ID`, `USER_ROLE`) VALUES ('2', '2', 'ROLE_USER');
