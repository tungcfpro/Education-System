﻿use master
--drop database Edusys_TranPhuThanh_PS22219;
--go
create database Edusys_TranPhuThanh_PS22219;
go
use Edusys_TranPhuThanh_PS22219;
go


--INSERT INTO nhanvien VALUES (?,?,?,?);
--UPDATE nhanvien SET MatKhau = ? , HoTen = ? , VaiTro = ? WHERE MaNV = ?
--DELETE nhanvien WHERE MaNV = ?
--SELECT * FROM nhanvien
--SELECT * FROM nhanvien WHERE MaNV = ?



--INSERT INTO nguoihoc VALUES (?,?,?,?,?,?,?,?,?);
--UPDATE nguoihoc SET HoTen = ? ,GioiTinh = ?, NgaySinh = ? , DienThoai = ? , Email = ?, GhiChu = ?,NgayDK = ? WHERE MaNH = ?
--DELETE nguoihoc WHERE MaNH = ?
--SELECT * FROM nguoihoc
--SELECT * FROM nguoihoc WHERE MaNH = ?

-- Bảng Chuyên đề


--INSERT INTO chuyende VALUES (?,?,?,?,?);
--UPDATE chuyende SET TenCD = ?, HocPhi = ?,ThoiLuong = ?,Hinh =? ,Mota = ? WHERE MaCD = ?
--DELETE chuyende WHERE MaCD = ?
--SELECT * FROM chuyende
--SELECT * FROM chuyende WHERE MaCD = ?


--INSERT INTO khoahoc VALUES (?,?,?,?,?,?,?);
--UPDATE khoahoc SET TenCD = ?, HocPhi = ?,ThoiLuong = ?,NgayKG = ? , GhiChu = ? , NgayDK = ? , MaNV = ? WHERE MaKH = ?
--DELETE khoahoc WHERE MaKH = ?
--SELECT * FROM khoahoc
--SELECT * FROM khoahoc WHERE MaKH = ?


--INSERT INTO hocvien VALUES (?,?,?,?);
--UPDATE hocvien SET MaHV = ? , MaKH = ? , MaNH = ? , Diem = ? WHERE MaHV = ?
--DELETE hocvien WHERE MaHV = ?
--SELECT * FROM hocvien
--SELECT * FROM hocvien WHERE MaHV = ?


--Thêm dữ liệu bảng nhân viên

create table chuyende(
	MaCD nchar(5) NOT NULL,
	TenCD nvarchar(50) NOT NULL,
	HocPhi float NOT NULL,
	ThoiLuong int NOT NULL,
	Hinh nvarchar(50) NOT NULL,
	Mota nvarchar(250) NOT NULL
	CONSTRAINT chuyende_pk PRIMARY KEY(MaCD)
)

create table HocVien(
	MaHV int  NOT NULL, 
	MaKH int  NOT NULL, 
	MaNH nchar(7) NOT NULL,
	Diem float NOT NULL
	constraint hocvien_pk primary key (MaHV)
)

create table KhoaHoc(
	MaKH int NOT NULL,
	MaCD nchar(5) NOT NULL,
	HocPhi float NOT NULL,
	ThoiLuong int NOT NULL,
	NgayKG date NOT NULL,
	GhiChu nvarchar(50) NULL,
	MaNV nvarchar(50) NOT NULL,
	NgayTao date NOT NULL
	Constraint khoahoc_pk primary key (MaKH)
)

create table NguoiHoc(
	MaNH nchar(7) NOT NULL,
	HoTen nvarchar(50) NOT NULL,
	NgaySinh date NOT NULL,
	GioiTinh bit NOT NULL,
	DienThoai nvarchar(50) NOT NULL,
	Email nvarchar(50) NOT NULL,
	GhiChu nvarchar(250) NULL,
	MaNV nvarchar(50) NOT NULL,
	NgayDK date NOT NULL
	Constraint nguoihoc_pk primary key(MaNH)
)

create table NhanVien(
	MaNV nvarchar(50) NOT NULL, 
	MatKhau nvarchar(50) NOT NULL, 
	HoTen nvarchar(50) NOT NULL,
	VaiTro bit NOT NULL
	Constraint nhanvien_pk primary key (MaNV)
)


INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'JAV01', N'Lập trình Java cơ bản', 250, 90, N'GAME.png', N'JAV01 - Lập trình Java cơ bản')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'JAV02', N'Lập trình Java nâng cao', 300, 90, N'HTCS.jpg', N'JAV02 - Lập trình Java nâng cao')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'JAV03', N'Lập trình mạng với Java', 200, 70, N'INMA.jpg', N'JAV03 - Lập trình mạng với Java')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'JAV04', N'Lập trình desktop với Swing', 200, 70, N'ADAV.jpg', N'JAV04 - Lập trình desktop với Swing')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO01', N'Dự án với công nghệ MS.NET MVC', 300, 90, N'MOWE.png', N'PRO01 - Dự án với công nghệ MS.NET MVC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO02', N'Dự án với công nghệ Spring MVC', 300, 90, N'Subject.png', N'PRO02 - Dự án với công nghệ Spring MVC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO03', N'Dự án với công nghệ Servlet/JSP', 300, 90, N'GAME.png', N'PRO03 - Dự án với công nghệ Servlet/JSP')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO04', N'Dự án với AngularJS & WebAPI', 300, 90, N'HTCS.jpg', N'PRO04 - Dự án với AngularJS & WebAPI')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO05', N'Dự án với Swing & JDBC', 300, 90, N'INMA.jpg', N'PRO05 - Dự án với Swing & JDBC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'PRO06', N'Dự án với WindowForm', 300, 90, N'LAYO.jpg', N'PRO06 - Dự án với WindowForm')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'RDB01', N'Cơ sở dữ liệu SQL Server', 100, 50, N'MOWE.png', N'RDB01 - Cơ sở dữ liệu SQL Server')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'RDB02', N'Lập trình JDBC', 150, 60, N'Subject.png', N'RDB02 - Lập trình JDBC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'RDB03', N'Lập trình cơ sở dữ liệu Hibernate', 250, 80, N'GAME.png', N'RDB03 - Lập trình cơ sở dữ liệu Hibernate')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'SER01', N'Lập trình web với Servlet/JSP', 350, 100, N'HTCS.jpg', N'SER01 - Lập trình web với Servlet/JSP')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'SER02', N'Lập trình Spring MVC', 400, 110, N'INMA.jpg', N'SER02 - Lập trình Spring MVC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'SER03', N'Lập trình MS.NET MVC', 400, 110, N'LAYO.jpg', N'SER03 - Lập trình MS.NET MVC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'SER04', N'Xây dựng Web API với Spring MVC & ASP.NET MVC', 200, 70, N'MOWE.png', N'SER04 - Xây dựng Web API với Spring MVC & ASP.NET MVC')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'WEB01', N'Thiết kế web với HTML và CSS', 200, 70, N'Subject.png', N'WEB01 - Thiết kế web với HTML và CSS')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'WEB02', N'Thiết kế web với Bootstrap', 0, 40, N'GAME.png', N'WEB02 - Thiết kế web với Bootstrap')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'WEB03', N'Lập trình front-end với JavaScript và jQuery', 150, 60, N'HTCS.jpg', N'WEB03 - Lập trình front-end với JavaScript và jQuery')
INSERT INTO ChuyenDe (MaCD, TenCD, HocPhi, ThoiLuong, Hinh, Mota) VALUES (N'WEB04', N'Lập trình AngularJS', 250, 80, N'INMA.jpg', N'WEB04 - Lập trình AngularJS')

INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1, 2, N'PS01638', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (8, 2, N'PS02988', 3)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (12, 3, N'PS02037', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (13, 3, N'PS02771', 7)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (14, 3, N'PS02867', 2)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (15, 3, N'PS02930', 1)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (16, 1, N'PS01638', 8)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (17, 1, N'PS02037', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (19, 1, N'PS02867', 3)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (20, 1, N'PS02930', 7)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (33, 1, N'PS02771', 8)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (34, 1, N'PS02979', 4)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (35, 1, N'PS02983', 6)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (36, 1, N'PS02988', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (37, 1, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (38, 1, N'PS03046', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (39, 1, N'PS03080', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (40, 1, N'PS03088', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (41, 1, N'PS03096', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (42, 1, N'PS03104', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (43, 1, N'PS03120', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (44, 1, N'PS03130', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (45, 3, N'PS02983', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (46, 3, N'PS03096', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (47, 3, N'PS03120', 6)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (48, 3, N'PS03046', 7)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (53, 5, N'PS01638', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (54, 5, N'PS02771', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (56, 5, N'PS02037', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (57, 4, N'PS01638', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (58, 4, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (59, 4, N'PS02979', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1052, 1005, N'PS01638', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1053, 1005, N'PS02037', 8)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1054, 1005, N'PS02771', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1055, 1005, N'PS02867', 7)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1056, 1005, N'PS02930', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1057, 1006, N'PS02930', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1058, 1006, N'PS02979', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1059, 1006, N'PS02983', 4)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1060, 1006, N'PS02988', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1061, 1006, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1062, 1006, N'PS03046', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1063, 1006, N'PS03080', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1064, 1007, N'PS02988', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1065, 1007, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1066, 1007, N'PS03046', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1067, 1007, N'PS03080', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1068, 1007, N'PS03088', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1069, 1007, N'PS03096', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1070, 1007, N'PS03104', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1071, 1007, N'PS03120', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1072, 1007, N'PS03130', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1073, 1009, N'PS03134', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1074, 1009, N'PS03172', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1075, 1009, N'PS03202', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1076, 1009, N'PS03203', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1077, 1009, N'PS03205', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1078, 1009, N'PS03222', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1079, 1009, N'PS03230', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1080, 1009, N'PS03233', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1081, 1009, N'PS03251', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1082, 1009, N'PS03304', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1083, 1009, N'PS03306', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1084, 1009, N'PS03308', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1085, 1009, N'PS03325', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1086, 1009, N'PS03346', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1087, 1009, N'PS03383', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1088, 1011, N'PS03425', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1089, 1011, N'PS03454', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1090, 1011, N'PS03472', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1091, 1011, N'PS03488', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1092, 1011, N'PS03530', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1093, 1011, N'PS03553', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1094, 1011, N'PS03561', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1095, 1011, N'PS03596', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1096, 1011, N'PS03603', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1097, 1011, N'PS03610', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1098, 1011, N'PS03614', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1099, 1011, N'PS03618', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1100, 1011, N'PS03638', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1101, 1011, N'PS03640', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1102, 1011, N'PS03662', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1103, 1011, N'PS03674', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1104, 5, N'PS03230', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1105, 5, N'PS03233', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1106, 5, N'PS03251', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1107, 5, N'PS03304', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1108, 5, N'PS03306', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1109, 5, N'PS03308', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1110, 5, N'PS03325', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1111, 5, N'PS03346', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1112, 5, N'PS03383', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1113, 5, N'PS03389', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1114, 5, N'PS03410', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1115, 5, N'PS03411', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1116, 1012, N'PS01638', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1117, 1012, N'PS02037', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1118, 1012, N'PS02771', 0)
GO
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1119, 1012, N'PS02867', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1120, 1012, N'PS02930', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1121, 1012, N'PS02979', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1122, 1012, N'PS02983', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1123, 1012, N'PS02988', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1124, 1012, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1125, 1012, N'PS03046', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1126, 1012, N'PS03080', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1127, 1012, N'PS03088', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1128, 1013, N'PS02037', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1129, 1013, N'PS02771', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1130, 1013, N'PS02867', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1131, 1013, N'PS02930', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1132, 1013, N'PS02979', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1133, 1013, N'PS02983', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1134, 1013, N'PS02988', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1135, 1013, N'PS03031', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1136, 1013, N'PS03046', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1137, 1013, N'PS03080', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1138, 1014, N'PS03088', 5)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1139, 1014, N'PS03096', 6)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1140, 1014, N'PS03104', 8)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1141, 1014, N'PS03120', 2)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1142, 1014, N'PS03130', 9)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1143, 1014, N'PS03134', 10)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1144, 1014, N'PS03172', 10)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (1145, 1014, N'PS03202', 7)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2049, 1005, N'PS03488', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2050, 1005, N'PS03553', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2051, 1005, N'PS03596', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2052, 1005, N'PS03104', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2053, 1005, N'PS03411', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2054, 1005, N'PS03530', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2055, 1013, N'PS03088', 0)
INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (2056, 1013, N'PS03104', 0)

INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1, N'PRO02', 300, 90, CAST(0xBF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (2, N'JAV04', 300, 90, CAST(0xDF3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (3, N'JAV04', 100, 50, CAST(0xFC3D0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (4, N'JAV04', 250, 80, CAST(0x103E0B00 AS Date), N'', N'TeoNV', CAST(0xB53D0B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (5, N'PRO04', 300, 90, CAST(0xD3400B00 AS Date), N'', N'TeoNV', CAST(0xE6400B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1005, N'JAV01', 300, 90, CAST(0xF6400B00 AS Date), N'Lập trình Java cơ bản', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1006, N'JAV02', 300, 90, CAST(0xF6400B00 AS Date), N'Lập trình Java nâng cao', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1007, N'JAV03', 200, 70, CAST(0xF6400B00 AS Date), N'Lập trình mạng với Java', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1008, N'JAV04', 200, 70, CAST(0xF6400B00 AS Date), N'Lập trình ứng dụng Desktop với Java', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1009, N'PRO01', 300, 90, CAST(0xF6400B00 AS Date), N'Lập trình .NET MVC', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1010, N'PRO02', 300, 90, CAST(0xF6400B00 AS Date), N'Lập trình Spring MVC', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1011, N'PRO03', 300, 90, CAST(0xF6400B00 AS Date), N'Làm dự án với Servlet và JSP', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1012, N'PRO04', 300, 90, CAST(0xF6400B00 AS Date), N'Làm dự án với REST API và AngularJS', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1013, N'JAV01', 300, 90, CAST(0xF4400B00 AS Date), N'Lập trình Java cơ bản', N'TeoNV', CAST(0x0A410B00 AS Date))
INSERT INTO KhoaHoc (MaKH, MaCD, HocPhi, ThoiLuong, NgayKG, GhiChu, MaNV, NgayTao) VALUES (1014, N'JAV01', 250, 90, CAST(0xF2400B00 AS Date), N'Lập trình Java cơ bản', N'TeoNV', CAST(0x0A410B00 AS Date))

INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS01638', N'LỮ HUY CƯỜNG', CAST(0xAF170B00 AS Date), 0, N'0928768265', N'PS01638@fpt.edu.vn', N'0928768265 - LỮ HUY CƯỜNG', N'TeoNV', CAST(0xAF170B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02037', N'ĐỖ VĂN MINH', CAST(0xC6190B00 AS Date), 1, N'0968095685', N'PS02037@fpt.edu.vn', N'0968095685 - ĐỖ VĂN MINH', N'PheoNC', CAST(0xC6190B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02771', N'NGUYỄN TẤN HIẾU', CAST(0x2E220B00 AS Date), 1, N'0927594734', N'PS02771@fpt.edu.vn', N'0927594734 - NGUYỄN TẤN HIẾU', N'PheoNC', CAST(0x2E220B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02867', N'NGUYỄN HỮU TRÍ', CAST(0xEB200B00 AS Date), 1, N'0946984711', N'PS02867@fpt.edu.vn', N'0946984711 - NGUYỄN HỮU TRÍ', N'TeoNV', CAST(0xEB200B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02930', N'TRẦN VĂN NAM', CAST(0xA1240B00 AS Date), 1, N'0924774498', N'PS02930@fpt.edu.vn', N'0924774498 - TRẦN VĂN NAM', N'TeoNV', CAST(0xA1240B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02979', N'ĐOÀN TRẦN NHẬT VŨ', CAST(0x671C0B00 AS Date), 1, N'0912374818', N'PS02979@fpt.edu.vn', N'0912374818 - ĐOÀN TRẦN NHẬT VŨ', N'TeoNV', CAST(0x671C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02983', N'NGUYỄN HOÀNG THIÊN PHƯỚC', CAST(0x681A0B00 AS Date), 1, N'0912499836', N'PS02983@fpt.edu.vn', N'0912499836 - NGUYỄN HOÀNG THIÊN PHƯỚC', N'PheoNC', CAST(0x681A0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS02988', N'HỒ HỮU HẬU', CAST(0x311A0B00 AS Date), 1, N'0924984876', N'PS02988@fpt.edu.vn', N'0924984876 - HỒ HỮU HẬU', N'PheoNC', CAST(0x311A0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03031', N'PHAN TẤN VIỆT', CAST(0x21160B00 AS Date), 1, N'0924832716', N'PS03031@fpt.edu.vn', N'0924832716 - PHAN TẤN VIỆT', N'PheoNC', CAST(0x21160B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03046', N'NGUYỄN CAO PHƯỚC', CAST(0xDE150B00 AS Date), 1, N'0977117727', N'PS03046@fpt.edu.vn', N'0977117727 - NGUYỄN CAO PHƯỚC', N'PheoNC', CAST(0xDE150B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03080', N'HUỲNH THANH HUY', CAST(0x701C0B00 AS Date), 1, N'0916436052', N'PS03080@fpt.edu.vn', N'0916436052 - HUỲNH THANH HUY', N'PheoNC', CAST(0x701C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03088', N'NGUYỄN HOÀNG TRUNG', CAST(0x24180B00 AS Date), 1, N'0938101529', N'PS03088@fpt.edu.vn', N'0938101529 - NGUYỄN HOÀNG TRUNG', N'PheoNC', CAST(0x24180B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03096', N'ĐOÀN HỮU KHANG', CAST(0xAB1B0B00 AS Date), 1, N'0945196719', N'PS03096@fpt.edu.vn', N'0945196719 - ĐOÀN HỮU KHANG', N'PheoNC', CAST(0xAB1B0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03104', N'LÊ THÀNH PHƯƠNG', CAST(0x3E1A0B00 AS Date), 0, N'0922948096', N'PS03104@fpt.edu.vn', N'0922948096 - LÊ THÀNH PHƯƠNG', N'TeoNV', CAST(0x3E1A0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03120', N'PHẠM NGỌC NHẬT TRƯỜNG', CAST(0x48230B00 AS Date), 1, N'0994296169', N'PS03120@fpt.edu.vn', N'0994296169 - PHẠM NGỌC NHẬT TRƯỜNG', N'PheoNC', CAST(0x48230B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03130', N'ĐẶNG BẢO VIỆT', CAST(0xEF150B00 AS Date), 1, N'0917749344', N'PS03130@fpt.edu.vn', N'0917749344 - ĐẶNG BẢO VIỆT', N'PheoNC', CAST(0xEF150B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03134', N'LÊ DUY BẢO', CAST(0x2E1F0B00 AS Date), 1, N'0926714368', N'PS03134@fpt.edu.vn', N'0926714368 - LÊ DUY BẢO', N'PheoNC', CAST(0x2E1F0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03172', N'NGUYỄN ANH TUẤN', CAST(0xCA180B00 AS Date), 1, N'0920020472', N'PS03172@fpt.edu.vn', N'0920020472 - NGUYỄN ANH TUẤN', N'PheoNC', CAST(0xCA180B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03202', N'PHAN QUỐC QUI', CAST(0x741E0B00 AS Date), 1, N'0930649274', N'PS03202@fpt.edu.vn', N'0930649274 - PHAN QUỐC QUI', N'PheoNC', CAST(0x741E0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03203', N'ĐẶNG LÊ QUANG VINH', CAST(0xC4150B00 AS Date), 1, N'0920197355', N'PS03203@fpt.edu.vn', N'0920197355 - ĐẶNG LÊ QUANG VINH', N'PheoNC', CAST(0xC4150B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03205', N'NGUYỄN MINH SANG', CAST(0x5E1D0B00 AS Date), 1, N'0967006218', N'PS03205@fpt.edu.vn', N'0967006218 - NGUYỄN MINH SANG', N'PheoNC', CAST(0x5E1D0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03222', N'TRẦM MINH MẪN', CAST(0xE71F0B00 AS Date), 1, N'0911183649', N'PS03222@fpt.edu.vn', N'0911183649 - TRẦM MINH MẪN', N'PheoNC', CAST(0xE71F0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03230', N'NGUYỄN PHẠM MINH HÂN', CAST(0x26250B00 AS Date), 1, N'0983469892', N'PS03230@fpt.edu.vn', N'0983469892 - NGUYỄN PHẠM MINH HÂN', N'PheoNC', CAST(0x26250B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03233', N'LƯU KIM HOÀNG DUY', CAST(0x0B1F0B00 AS Date), 1, N'0938357735', N'PS03233@fpt.edu.vn', N'0938357735 - LƯU KIM HOÀNG DUY', N'PheoNC', CAST(0x0B1F0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03251', N'TRẦN QUANG VŨ', CAST(0x4C240B00 AS Date), 1, N'0914531913', N'PS03251@fpt.edu.vn', N'0914531913 - TRẦN QUANG VŨ', N'PheoNC', CAST(0x4C240B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03304', N'BÙI NGỌC THUẬN', CAST(0xFE1C0B00 AS Date), 1, N'0999794115', N'PS03304@fpt.edu.vn', N'0999794115 - BÙI NGỌC THUẬN', N'PheoNC', CAST(0xFE1C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03306', N'HỒ VĂN HÀNH', CAST(0x06190B00 AS Date), 1, N'0912277868', N'PS03306@fpt.edu.vn', N'0912277868 - HỒ VĂN HÀNH', N'PheoNC', CAST(0x06190B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03308', N'TRẦN VIẾT HÙNG', CAST(0xD0220B00 AS Date), 1, N'0916050164', N'PS03308@fpt.edu.vn', N'0916050164 - TRẦN VIẾT HÙNG', N'PheoNC', CAST(0xD0220B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03325', N'NGUYỄN HOÀNG MINH ĐỨC', CAST(0xAB1F0B00 AS Date), 1, N'0912234437', N'PS03325@fpt.edu.vn', N'0912234437 - NGUYỄN HOÀNG MINH ĐỨC', N'PheoNC', CAST(0xAB1F0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03346', N'PHAN THANH PHONG', CAST(0xD7150B00 AS Date), 1, N'0937891282', N'PS03346@fpt.edu.vn', N'0937891282 - PHAN THANH PHONG', N'PheoNC', CAST(0xD7150B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03383', N'TRẦN VŨ LUÂN', CAST(0x8E210B00 AS Date), 1, N'0962030316', N'PS03383@fpt.edu.vn', N'0962030316 - TRẦN VŨ LUÂN', N'PheoNC', CAST(0x8E210B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03389', N'VŨ ĐỨC TUẤN', CAST(0x411A0B00 AS Date), 1, N'0911637415', N'PS03389@fpt.edu.vn', N'0911637415 - VŨ ĐỨC TUẤN', N'PheoNC', CAST(0x411A0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03410', N'TRẦN  NHẠT', CAST(0x3C190B00 AS Date), 1, N'0946219377', N'PS03410@fpt.edu.vn', N'0946219377 - TRẦN  NHẠT', N'PheoNC', CAST(0x3C190B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03411', N'TRƯƠNG THÀNH ĐẠT', CAST(0x3F1B0B00 AS Date), 1, N'0991509408', N'PS03411@fpt.edu.vn', N'0991509408 - TRƯƠNG THÀNH ĐẠT', N'PheoNC', CAST(0x3F1B0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03425', N'TÔ VĂN NĂNG', CAST(0x6E190B00 AS Date), 1, N'0915134551', N'PS03425@fpt.edu.vn', N'0915134551 - TÔ VĂN NĂNG', N'PheoNC', CAST(0x6E190B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03454', N'NGUYỄN NHẬT VĨNH', CAST(0x57230B00 AS Date), 1, N'0917886371', N'PS03454@fpt.edu.vn', N'0917886371 - NGUYỄN NHẬT VĨNH', N'PheoNC', CAST(0x57230B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03472', N'NGUYỄN VĂN HUY', CAST(0xD8150B00 AS Date), 1, N'0960620997', N'PS03472@fpt.edu.vn', N'0960620997 - NGUYỄN VĂN HUY', N'PheoNC', CAST(0xD8150B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03488', N'NGUYỄN NHƯ NGỌC', CAST(0x651D0B00 AS Date), 0, N'0912880267', N'PS03488@fpt.edu.vn', N'0912880267 - NGUYỄN NHƯ NGỌC', N'PheoNC', CAST(0x651D0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03530', N'PHẠM THÀNH TÂM', CAST(0x4D240B00 AS Date), 1, N'0918161783', N'PS03530@fpt.edu.vn', N'0918161783 - PHẠM THÀNH TÂM', N'PheoNC', CAST(0x4D240B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03553', N'ĐINH TẤN CÔNG', CAST(0xEA240B00 AS Date), 1, N'0918182551', N'PS03553@fpt.edu.vn', N'0918182551 - ĐINH TẤN CÔNG', N'PheoNC', CAST(0xEA240B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03561', N'LÊ MINH ĐIỀN', CAST(0xE91C0B00 AS Date), 1, N'0948199564', N'PS03561@fpt.edu.vn', N'0948199564 - LÊ MINH ĐIỀN', N'PheoNC', CAST(0xE91C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03596', N'NGUYỄN THANH HIỀN', CAST(0xED170B00 AS Date), 1, N'0910545901', N'PS03596@fpt.edu.vn', N'0910545901 - NGUYỄN THANH HIỀN', N'PheoNC', CAST(0xED170B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03603', N'LÊ PHẠM KIM THANH', CAST(0x501C0B00 AS Date), 0, N'0924696779', N'PS03603@fpt.edu.vn', N'0924696779 - LÊ PHẠM KIM THANH', N'PheoNC', CAST(0x501C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03610', N'TRẦN ĐÌNH TRƯỜNG', CAST(0xF41C0B00 AS Date), 1, N'0941528106', N'PS03610@fpt.edu.vn', N'0941528106 - TRẦN ĐÌNH TRƯỜNG', N'PheoNC', CAST(0xF41C0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03614', N'NGUYỄN VĂN SÁU', CAST(0x37160B00 AS Date), 1, N'0940711328', N'PS03614@fpt.edu.vn', N'0940711328 - NGUYỄN VĂN SÁU', N'PheoNC', CAST(0x37160B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03618', N'PHÍ ĐÌNH VIỆT HÙNG', CAST(0xA91F0B00 AS Date), 1, N'0939020097', N'PS03618@fpt.edu.vn', N'0939020097 - PHÍ ĐÌNH VIỆT HÙNG', N'PheoNC', CAST(0xA91F0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03638', N'PHẠM NHẬT MINH', CAST(0x86200B00 AS Date), 1, N'0927771672', N'PS03638@fpt.edu.vn', N'0927771672 - PHẠM NHẬT MINH', N'PheoNC', CAST(0x86200B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03640', N'LƯU THANH NGỌC', CAST(0x591B0B00 AS Date), 0, N'0918358164', N'PS03640@fpt.edu.vn', N'0918358164 - LƯU THANH NGỌC', N'PheoNC', CAST(0x591B0B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03662', N'NGUYỄN CAO NGỌC LỢI', CAST(0x34160B00 AS Date), 1, N'0930260679', N'PS03662@fpt.edu.vn', N'0930260679 - NGUYỄN CAO NGỌC LỢI', N'PheoNC', CAST(0x34160B00 AS Date))
INSERT INTO NguoiHoc (MaNH, HoTen, NgaySinh, GioiTinh, DienThoai, Email, GhiChu, MaNV, NgayDK) VALUES (N'PS03674', N'TRẦN TUẤN ANH', CAST(0xF41E0B00 AS Date), 1, N'0914082094', N'PS03674@fpt.edu.vn', N'0914082094 - TRẦN TUẤN ANH', N'PheoNC', CAST(0xF41E0B00 AS Date))
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'LongNDH', N'songlong', N'Nguyễn Đình Hoàng Long', 0)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'LongNDT', N'songlong', N'Nguyễn Đình Thiên Long', 0)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'NghiemN', N'songlong', N'Nguyễn Nghiệm', 1)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'NoPT', N'123456', N'Phạm Thị Nở', 0)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'PheoNC', N'123456', N'Nguyễn Chí Phèo', 0)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'TeoNV', N'songlong', N'Nguyễn Văn Tèo', 1)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'ThaoLTH', N'songlong', N'Lê Thị Hương Thảo', 0)
INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (N'123', N'123', N'Trần Phú Thành', 1)

go
create proc sp_ThongKeNguoiHoc as
begin
SELECT   YEAR(NgayDK) Nam,   COUNT(*) SoLuong,   MIN(NgayDK) DauTien,   MAX(NgayDK) CuoiCung  FROM NguoiHoc  GROUP BY YEAR(NgayDK)
end

go
create proc sp_ThongKeDoanhThu  @Year int AS 
BEGIN  
SELECT   TenCD ChuyenDe,   COUNT(DISTINCT kh.MaKH) SoKH,   COUNT(hv.MaHV) SoHV,   SUM(kh.HocPhi) DoanhThu,   MIN(kh.HocPhi) ThapNhat,   MAX(kh.HocPhi) CaoNhat,   AVG(kh.HocPhi) TrungBinh  FROM KhoaHoc kh   JOIN HocVien hv ON kh.MaKH=hv.MaKH   JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD  WHERE YEAR(NgayKG) = @Year  GROUP BY TenCD 
end

go
create proc sp_ThongKeDiem AS
BEGIN  
SELECT   TenCD ChuyenDe,   COUNT(MaHV) SoHV,   MIN(Diem) ThapNhat,   MAX(Diem) CaoNhat,   AVG(Diem) TrungBinh  FROM KhoaHoc kh   JOIN HocVien hv ON kh.MaKH=hv.MaKH   JOIN ChuyenDe cd ON cd.MaCD=kh.MaCD  GROUP BY TenCD 
END 

go
create proc sp_BangDiem @MaKH int  AS 
BEGIN  
SELECT   nh.MaNH,   nh.HoTen,   hv.Diem  FROM HocVien hv   JOIN NguoiHoc nh ON nh.MaNH=hv.MaNH  WHERE hv.MaKH = @MaKH  ORDER BY hv.Diem DESC 
END 