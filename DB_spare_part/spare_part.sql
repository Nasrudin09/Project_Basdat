-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 23, 2022 at 06:12 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `spare_part`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `ID_TRANSAKSI` int(11) NOT NULL,
  `ID_PRODUK` int(11) NOT NULL,
  `JUMLAH_HARGA` varchar(11) NOT NULL,
  `JUMLAH_PRODUK` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`ID_TRANSAKSI`, `ID_PRODUK`, `JUMLAH_HARGA`, `JUMLAH_PRODUK`) VALUES
(1, 1, '100000', '2'),
(2, 2, '195000', '3'),
(3, 3, '200000', '4'),
(4, 4, '325000', '5'),
(5, 5, '200000', '1'),
(6, 6, '900000', '2'),
(7, 7, '600000', '3'),
(8, 8, '1800000', '4'),
(9, 9, '1000000', '5'),
(11, 16, '40000', '2'),
(12, 16, '80000', '2');

-- --------------------------------------------------------

--
-- Table structure for table `jabatan`
--

CREATE TABLE `jabatan` (
  `ID_JABATAN` int(11) NOT NULL,
  `NAMA_JABATAN` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jabatan`
--

INSERT INTO `jabatan` (`ID_JABATAN`, `NAMA_JABATAN`) VALUES
(1, 'kasir'),
(2, 'gudang');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_produk`
--

CREATE TABLE `jenis_produk` (
  `ID_JENIS_PRODUK` int(11) NOT NULL,
  `NAMA_JENIS_PRODUK` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_produk`
--

INSERT INTO `jenis_produk` (`ID_JENIS_PRODUK`, `NAMA_JENIS_PRODUK`) VALUES
(1, 'oli_gardan\r\n'),
(2, 'oli_mesin\r\n'),
(3, 'ban_biasa'),
(4, 'ban_tubles');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `ID_KATEGORI` int(11) NOT NULL,
  `ID_JENIS_PRODUK` int(11) DEFAULT NULL,
  `NAMA_KATEGORI` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`ID_KATEGORI`, `ID_JENIS_PRODUK`, `NAMA_KATEGORI`) VALUES
(1, 1, 'oli_motor1'),
(2, 2, 'oli_motor2'),
(3, 3, 'ban_motor1'),
(4, 4, 'ban_motor2');

-- --------------------------------------------------------

--
-- Table structure for table `merk`
--

CREATE TABLE `merk` (
  `ID_MERK` int(11) NOT NULL,
  `NAMA_MERK` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merk`
--

INSERT INTO `merk` (`ID_MERK`, `NAMA_MERK`) VALUES
(1, 'spx-1'),
(2, 'spx-2'),
(3, 'mpx-1'),
(4, 'mpx-2'),
(5, 'flemmo'),
(6, 'sport_XR'),
(7, 'hover'),
(8, 'genzi_PRO');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `ID_PEGAWAI` int(11) NOT NULL,
  `ID_JABATAN` int(11) DEFAULT NULL,
  `NAMA_PEGAWAI` varchar(100) DEFAULT NULL,
  `NO_TELFON` varchar(20) DEFAULT NULL,
  `PASSWORD` varchar(100) DEFAULT NULL,
  `USERNAME` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`ID_PEGAWAI`, `ID_JABATAN`, `NAMA_PEGAWAI`, `NO_TELFON`, `PASSWORD`, `USERNAME`) VALUES
(1, 1, 'nasrudin', '081336474884', '123', 'nas'),
(2, 1, 'ardiansyah', '081336474884', '123', 'ard'),
(3, 2, 'nasrud', '081336474884', '1213', 'nasr'),
(4, 2, 'arsh', '081336474884', '123', 'arsh');

-- --------------------------------------------------------

--
-- Table structure for table `pembeli`
--

CREATE TABLE `pembeli` (
  `ID_PEMBELI` int(11) NOT NULL,
  `NAMA_PEMBELI` varchar(100) DEFAULT NULL,
  `NO_HP` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembeli`
--

INSERT INTO `pembeli` (`ID_PEMBELI`, `NAMA_PEMBELI`, `NO_HP`, `ALAMAT`) VALUES
(1, 'nasrudin', '081336474884', 'mojokerto'),
(2, 'jaisyullah', '081336474884', 'jombang'),
(3, 'ardiansyah', '081336474884', 'nganjuk'),
(4, 'bagas', '081336474884', 'madiun'),
(5, 'bagus', '08133647488', 'pekalongan'),
(6, 'asy_syuja', '081336474884', 'bandung'),
(7, 'fatimah', '081336474884', 'jakarta'),
(8, 'ahmad', '081336474884', 'balikpapan'),
(9, 'alxander', '081336474884', 'jakarta'),
(10, 'izzul', '081336474884', 'makassar'),
(11, 'arsh_cuy', '081', 'denmark'),
(12, 'Jaisyullah', '081336474884', 'Mojokerto');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `ID_PRODUK` int(11) NOT NULL,
  `ID_KATEGORI` int(11) DEFAULT NULL,
  `ID_MERK` int(11) DEFAULT NULL,
  `ID_SUPPLIER` int(11) DEFAULT NULL,
  `NAMA_PRODUK` varchar(100) DEFAULT NULL,
  `HARGA` double DEFAULT NULL,
  `STOK` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`ID_PRODUK`, `ID_KATEGORI`, `ID_MERK`, `ID_SUPPLIER`, `NAMA_PRODUK`, `HARGA`, `STOK`) VALUES
(1, 1, 1, 1, 'AHM', 50000, 50),
(2, 2, 2, 2, 'AHM', 65000, 50),
(3, 1, 2, 3, 'AHM', 50000, 50),
(4, 2, 1, 4, 'AHM', 65000, 50),
(5, 3, 5, 5, 'Federal', 200000, 50),
(6, 4, 5, 6, 'Federal', 450000, 50),
(7, 3, 6, 7, 'Federal', 200000, 50),
(8, 4, 6, 8, 'Federal', 450000, 50),
(9, 3, 7, 9, 'Federal', 200000, 50),
(11, 3, 8, 7, 'Federal', 200000, 50),
(15, 1, 1, NULL, 'qwe', 30000, 12),
(16, 1, 1, 2, 'ABB', 40000, 16);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `ID_SUPPLIER` int(11) NOT NULL,
  `NAMA_SUPPLIER` varchar(100) DEFAULT NULL,
  `ALAMAT_SUPPLIER` varchar(100) DEFAULT NULL,
  `NOMER_TELFON` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`ID_SUPPLIER`, `NAMA_SUPPLIER`, `ALAMAT_SUPPLIER`, `NOMER_TELFON`) VALUES
(1, 'irfan', 'solo', '081336474884'),
(2, 'yasir', 'yogjakarta', '081336474884'),
(3, 'ilyas', 'sumenep', '081336474884'),
(4, 'shofi', 'jombang', '081336474884'),
(5, 'yusuf', 'magetan', '081336474884'),
(6, 'ilha', 'bekasi', '081336474884'),
(7, 'ilham', 'depok', '081336474884'),
(8, 'ardianto', 'manggarai', '081336474884'),
(9, 'aris', 'surabaya', '081336474884'),
(10, 'abqori', 'sidoarjo', '081336474884');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_TRANSAKSI` int(11) NOT NULL,
  `ID_PEGAWAI` int(11) DEFAULT NULL,
  `ID_PEMBELI` int(11) DEFAULT NULL,
  `TANGGAL_TRANSAKSI` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`ID_TRANSAKSI`, `ID_PEGAWAI`, `ID_PEMBELI`, `TANGGAL_TRANSAKSI`) VALUES
(1, 1, 2, '2022-06-20'),
(2, 2, 4, '2022-06-14'),
(3, 3, 1, '2022-06-02'),
(4, 4, 3, '2022-06-16'),
(5, 1, 5, '2022-06-15'),
(6, 2, 6, '2022-06-06'),
(7, 3, 7, '2022-06-17'),
(8, 4, 8, '2022-06-22'),
(9, 1, 9, '2022-06-21'),
(10, 2, 10, '2022-06-25'),
(11, 4, 11, '2022-06-22'),
(12, 4, 12, '2022-06-23');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD KEY `FK_DETAIL_TRANSAKSI` (`ID_TRANSAKSI`),
  ADD KEY `FK_DETAIL_TRANSAKSI2` (`ID_PRODUK`);

--
-- Indexes for table `jabatan`
--
ALTER TABLE `jabatan`
  ADD PRIMARY KEY (`ID_JABATAN`);

--
-- Indexes for table `jenis_produk`
--
ALTER TABLE `jenis_produk`
  ADD PRIMARY KEY (`ID_JENIS_PRODUK`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`ID_KATEGORI`),
  ADD KEY `FK_MEMILIKI_3` (`ID_JENIS_PRODUK`);

--
-- Indexes for table `merk`
--
ALTER TABLE `merk`
  ADD PRIMARY KEY (`ID_MERK`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`ID_PEGAWAI`),
  ADD KEY `FK_MEMPUNYAI` (`ID_JABATAN`);

--
-- Indexes for table `pembeli`
--
ALTER TABLE `pembeli`
  ADD PRIMARY KEY (`ID_PEMBELI`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`ID_PRODUK`),
  ADD KEY `FK_MEMILIKI_1` (`ID_MERK`),
  ADD KEY `FK_MEMILIKI_2` (`ID_KATEGORI`),
  ADD KEY `FK_REFERENCE_10` (`ID_SUPPLIER`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`ID_SUPPLIER`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_TRANSAKSI`),
  ADD KEY `FK_MEGELOLA` (`ID_PEGAWAI`),
  ADD KEY `FK_MELAKUKAN` (`ID_PEMBELI`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jabatan`
--
ALTER TABLE `jabatan`
  MODIFY `ID_JABATAN` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jenis_produk`
--
ALTER TABLE `jenis_produk`
  MODIFY `ID_JENIS_PRODUK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `ID_KATEGORI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `merk`
--
ALTER TABLE `merk`
  MODIFY `ID_MERK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `pegawai`
--
ALTER TABLE `pegawai`
  MODIFY `ID_PEGAWAI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `pembeli`
--
ALTER TABLE `pembeli`
  MODIFY `ID_PEMBELI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `ID_PRODUK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `supplier`
--
ALTER TABLE `supplier`
  MODIFY `ID_SUPPLIER` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `ID_TRANSAKSI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `FK_DETAIL_TRANSAKSI` FOREIGN KEY (`ID_TRANSAKSI`) REFERENCES `transaksi` (`ID_TRANSAKSI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DETAIL_TRANSAKSI2` FOREIGN KEY (`ID_PRODUK`) REFERENCES `produk` (`ID_PRODUK`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `kategori`
--
ALTER TABLE `kategori`
  ADD CONSTRAINT `FK_MEMILIKI_3` FOREIGN KEY (`ID_JENIS_PRODUK`) REFERENCES `jenis_produk` (`ID_JENIS_PRODUK`);

--
-- Constraints for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD CONSTRAINT `FK_MEMPUNYAI` FOREIGN KEY (`ID_JABATAN`) REFERENCES `jabatan` (`ID_JABATAN`);

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `FK_MEMILIKI_1` FOREIGN KEY (`ID_MERK`) REFERENCES `merk` (`ID_MERK`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MEMILIKI_2` FOREIGN KEY (`ID_KATEGORI`) REFERENCES `kategori` (`ID_KATEGORI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`ID_SUPPLIER`) REFERENCES `supplier` (`ID_SUPPLIER`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FK_MEGELOLA` FOREIGN KEY (`ID_PEGAWAI`) REFERENCES `pegawai` (`ID_PEGAWAI`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MELAKUKAN` FOREIGN KEY (`ID_PEMBELI`) REFERENCES `pembeli` (`ID_PEMBELI`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
