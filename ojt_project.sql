-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 11, 2026 at 03:39 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ojt_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `logbook_in`
--

CREATE TABLE `logbook_in` (
  `id` int(11) NOT NULL,
  `office` varchar(255) NOT NULL,
  `received` varchar(255) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logbook_in`
--

INSERT INTO `logbook_in` (`id`, `office`, `received`, `file_name`, `date`, `time`) VALUES
(13, 'president', 'Igy Luis Fuentiblancawqd', 'something', '2026-03-09', '13:40:00'),
(16, 'President', 'Something', 'something', '2026-03-09', '16:04:00'),
(20, 'president', 'Marry San Gaspar', 'something.pdf', '2026-03-10', '23:33:43'),
(22, 'president', 'qwdqwdqwdqwdqwd', 'wdqw', '2026-03-11', '17:13:04'),
(23, 'president', 'Juan Dela Cruz', 'budget_report.pdf', '2026-03-01', '09:15:00'),
(24, 'executive_vp', 'Maria Santos', 'meeting_minutes.docx', '2026-03-02', '10:30:00'),
(25, 'vp_of_academic_affairs', 'Carlos Reyes', 'curriculum_update.xlsx', '2026-03-03', '14:00:00'),
(26, 'vp_for_administration_and_finance', 'Ana Lopez', 'financial_statement.pdf', '2026-03-04', '11:45:00'),
(27, 'college_and_board_secretary', 'Jose Ramirez', 'board_resolution.docx', '2026-03-05', '13:20:00'),
(28, 'others', 'Liza Cruz', 'misc_notes.txt', '2026-03-06', '08:50:00'),
(29, 'president', 'Mark Villanueva', 'policy_draft.pdf', '2026-03-07', '15:10:00'),
(30, 'executive_vp', 'Nina Garcia', 'event_plan.docx', '2026-03-08', '09:40:00'),
(31, 'vp_of_academic_affairs', 'Paolo Mendoza', 'syllabus_update.pdf', '2026-03-09', '16:25:00'),
(32, 'vp_for_administration_and_finance', 'Rosa Lim', 'audit_report.pdf', '2026-03-10', '10:05:00'),
(33, 'college_and_board_secretary', 'Miguel Cruz', 'meeting_agenda.docx', '2026-03-11', '13:55:00'),
(34, 'others', 'Ella Santos', 'general_notice.txt', '2026-03-12', '08:30:00'),
(35, 'president', 'Leo Torres', 'annual_report.pdf', '2026-03-13', '09:00:00'),
(36, 'executive_vp', 'Grace Tan', 'project_summary.docx', '2026-03-14', '11:20:00'),
(37, 'vp_of_academic_affairs', 'Ivan Flores', 'exam_schedule.xlsx', '2026-03-15', '14:45:00'),
(38, 'vp_for_administration_and_finance', 'Sofia Ramos', 'budget_proposal.pdf', '2026-03-16', '10:10:00'),
(39, 'college_and_board_secretary', 'Diego Cruz', 'board_minutes.docx', '2026-03-17', '12:35:00'),
(40, 'others', 'Hannah Lee', 'misc_report.txt', '2026-03-18', '15:50:00'),
(41, 'president', 'Oliver Diaz', 'policy_review.pdf', '2026-03-19', '09:25:00'),
(42, 'executive_vp', 'Camille Reyes', 'event_notes.docx', '2026-03-20', '16:40:00');

-- --------------------------------------------------------

--
-- Table structure for table `logbook_out`
--

CREATE TABLE `logbook_out` (
  `id` int(11) NOT NULL,
  `office` varchar(255) NOT NULL,
  `received` varchar(255) NOT NULL,
  `file_name` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logbook_out`
--

INSERT INTO `logbook_out` (`id`, `office`, `received`, `file_name`, `date`, `time`) VALUES
(18, 'others', 'John Mayor Carlos', 'Bold ni Wally', '2026-03-03', '13:05:00'),
(19, 'president', 'John Mayor  soj3', 'qwe', '2026-03-08', '13:09:00'),
(20, 'president', 'qwdqwdqwdqwdqwdqwdqwd', 'qwdqwdwqdwd', '2026-03-11', '07:57:31'),
(21, 'president', 'Juan Dela Cruz', 'signed_budget_report.pdf', '2026-03-01', '17:15:00'),
(22, 'executive_vp', 'Maria Santos', 'approved_minutes.docx', '2026-03-02', '18:30:00'),
(23, 'vp_of_academic_affairs', 'Carlos Reyes', 'distributed_curriculum.xlsx', '2026-03-03', '19:00:00'),
(24, 'vp_for_administration_and_finance', 'Ana Lopez', 'released_financial_statement.pdf', '2026-03-04', '17:45:00'),
(25, 'college_and_board_secretary', 'Jose Ramirez', 'circulated_resolution.docx', '2026-03-05', '18:20:00'),
(26, 'others', 'Liza Cruz', 'forwarded_notes.txt', '2026-03-06', '16:50:00'),
(27, 'president', 'Mark Villanueva', 'policy_final.pdf', '2026-03-07', '20:10:00'),
(28, 'executive_vp', 'Nina Garcia', 'event_plan_shared.docx', '2026-03-08', '17:40:00'),
(29, 'vp_of_academic_affairs', 'Paolo Mendoza', 'syllabus_final.pdf', '2026-03-09', '19:25:00'),
(30, 'vp_for_administration_and_finance', 'Rosa Lim', 'audit_summary.pdf', '2026-03-10', '18:05:00'),
(31, 'college_and_board_secretary', 'Miguel Cruz', 'agenda_sent.docx', '2026-03-11', '17:55:00'),
(32, 'others', 'Ella Santos', 'notice_forwarded.txt', '2026-03-12', '16:30:00'),
(33, 'president', 'Leo Torres', 'annual_report_sent.pdf', '2026-03-13', '17:00:00'),
(34, 'executive_vp', 'Grace Tan', 'project_summary_shared.docx', '2026-03-14', '18:20:00'),
(35, 'vp_of_academic_affairs', 'Ivan Flores', 'exam_schedule_sent.xlsx', '2026-03-15', '19:45:00'),
(36, 'vp_for_administration_and_finance', 'Sofia Ramos', 'budget_proposal_sent.pdf', '2026-03-16', '18:10:00'),
(37, 'college_and_board_secretary', 'Diego Cruz', 'board_minutes_sent.docx', '2026-03-17', '17:35:00'),
(38, 'others', 'Hannah Lee', 'misc_report_sent.txt', '2026-03-18', '20:50:00'),
(39, 'president', 'Oliver Diaz', 'policy_review_sent.pdf', '2026-03-19', '17:25:00'),
(40, 'executive_vp', 'Camille Reyes', 'event_notes_sent.docx', '2026-03-20', '19:40:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logbook_in`
--
ALTER TABLE `logbook_in`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `logbook_out`
--
ALTER TABLE `logbook_out`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logbook_in`
--
ALTER TABLE `logbook_in`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `logbook_out`
--
ALTER TABLE `logbook_out`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
