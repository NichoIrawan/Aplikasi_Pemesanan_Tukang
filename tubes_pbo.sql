-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:8111
-- Waktu pembuatan: 07 Des 2024 pada 04.53
-- Versi server: 10.4.22-MariaDB
-- Versi PHP: 8.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubes_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `certifications`
--

CREATE TABLE `certifications` (
  `idCertif` int(10) NOT NULL,
  `nama` varchar(30) CHARACTER SET latin1 NOT NULL,
  `date_issued` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jadwal`
--

CREATE TABLE `jadwal` (
  `idJadwal` int(3) NOT NULL,
  `orderId` int(3) NOT NULL,
  `id_user` int(3) NOT NULL,
  `tukangId` int(3) NOT NULL,
  `tglPesanan` date NOT NULL,
  `jamMulai` time NOT NULL,
  `durasi` int(11) NOT NULL,
  `statusJadwal` enum('Pending','Confirmed','Cancelled','Completed') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `orders`
--

CREATE TABLE `orders` (
  `orderId` int(3) NOT NULL,
  `id_user` int(11) NOT NULL,
  `tukangId` int(11) NOT NULL,
  `harga` decimal(10,2) NOT NULL,
  `harga_negoisasi` decimal(10,2) NOT NULL,
  `status` enum('Pending','Confirmed','Cancelled','Completed') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `reviews`
--

CREATE TABLE `reviews` (
  `id_review` int(3) NOT NULL,
  `tukangId` int(3) NOT NULL,
  `id_user` int(3) NOT NULL,
  `ulasan` text NOT NULL,
  `rating` double NOT NULL,
  `tglReview` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `listTukang`
--

CREATE TABLE `listTukang` (
  `tukangId` int(3) NOT NULL,
  `id_user` int(3) NOT NULL,
  `service` varchar(50) CHARACTER SET latin1 NOT NULL,
  `rating` double NOT NULL,
  `certification` text NOT NULL,
  `balance` double NOT NULL,
  `verification` enum('unverified','verified') NOT NULL,
  `isAvailable` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `listTukang`
--

INSERT INTO `listTukang` (`tukangId`, `id_user`, `service`, `rating`, `certification`, `balance`, `verification`, `isAvailable`) VALUES
(1, 4, 'listrik', 5, '', 50000, 'verified', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `nama` varchar(50) CHARACTER SET latin1 NOT NULL,
  `email` varchar(30) CHARACTER SET latin1 NOT NULL,
  `no_hp` varchar(12) CHARACTER SET latin1 NOT NULL,
  `password` varchar(15) CHARACTER SET latin1 NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `hak_akses` enum('admin','listTukang','user') CHARACTER SET latin1 NOT NULL,
  `status` enum('active','suspended','inactive') CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `nama`, `email`, `no_hp`, `password`, `tanggal_lahir`, `hak_akses`, `status`) VALUES
(1, 'triana', 'triana1@gmail.com', '081376274893', 'admin', '2024-07-08', 'admin', 'active'),
(2, 'monica', 'monica1@gmail.com', '083636864863', 'user', '1996-12-04', 'user', 'active'),
(3, 'yanto', 'yanto1@gmail.com', '083859595682', 'listTukang', '1990-08-04', 'user', 'active'),
(4, 'yuyu', 'yuyu1@gmail.com', '083866386342', 'listTukang', '2014-12-03', 'listTukang', 'active'),
(5, 'intan', 'intan1@gmail.com', '084883838633', 'listTukang', '2005-09-04', 'listTukang', 'active');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `certifications`
--
ALTER TABLE `certifications`
  ADD PRIMARY KEY (`idCertif`);

--
-- Indeks untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`idJadwal`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `tukangId` (`tukangId`),
  ADD KEY `orderId` (`orderId`);

--
-- Indeks untuk tabel `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderId`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `tukangId` (`tukangId`);

--
-- Indeks untuk tabel `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id_review`),
  ADD KEY `tukangId` (`tukangId`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `listTukang`
--
ALTER TABLE `listTukang`
  ADD PRIMARY KEY (`tukangId`),
  ADD UNIQUE KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `certifications`
--
ALTER TABLE `certifications`
  MODIFY `idCertif` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `idJadwal` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `orders`
--
ALTER TABLE `orders`
  MODIFY `orderId` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id_review` int(3) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `listTukang`
--
ALTER TABLE `listTukang`
  MODIFY `tukangId` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `jadwal_ibfk_2` FOREIGN KEY (`tukangId`) REFERENCES `listTukang` (`tukangId`),
  ADD CONSTRAINT `jadwal_ibfk_3` FOREIGN KEY (`orderId`) REFERENCES `orders` (`orderId`);

--
-- Ketidakleluasaan untuk tabel `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`tukangId`) REFERENCES `listTukang` (`tukangId`);

--
-- Ketidakleluasaan untuk tabel `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`tukangId`) REFERENCES `listTukang` (`tukangId`),
  ADD CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Ketidakleluasaan untuk tabel `listTukang`
--
ALTER TABLE `listTukang`
  ADD CONSTRAINT `tukang_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `tukang_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
