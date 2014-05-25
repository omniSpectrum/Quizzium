-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Май 25 2014 г., 14:51
-- Версия сервера: 5.5.27
-- Версия PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `quizziumdb2`
--

--
-- Дамп данных таблицы `alternative`
--

INSERT INTO `alternative` (`alternativeId`, `description`, `Question_questionId`) VALUES
(1, 'Correct', 1),
(2, 'who knows', 1),
(3, 'probably', 1),
(4, 'undefinitly', 1),
(5, 'sometimes', 2),
(6, 'Correct', 2),
(7, 'I dont think', 2),
(8, 'after all', 2),
(9, 'will be', 3),
(10, 'however', 3),
(11, 'Correct', 3),
(12, 'find it', 3);

--
-- Дамп данных таблицы `correctanswer`
--

INSERT INTO `correctanswer` (`Question_questionId`, `Alternative_alternativeId`) VALUES
(1, 1),
(2, 6),
(3, 11);

--
-- Дамп данных таблицы `question`
--

INSERT INTO `question` (`questionId`, `description`, `Quizz_quizzId`) VALUES
(1, 'What is meaning of programming', 3),
(2, 'What is meaning of orange', 3),
(3, 'What is meaning of sun', 3);

--
-- Дамп данных таблицы `quizz`
--

INSERT INTO `quizz` (`quizzId`, `name`, `createdAt`, `Teacher_createdBy`, `QuizzStarted`, `QuizzEnded`) VALUES
(3, 'Mega first quiz', '2014-05-02 00:00:00', 4, '2014-05-04 18:00:00', '2014-05-17 20:00:00');

--
-- Дамп данных таблицы `student`
--

INSERT INTO `student` (`studentNumber`) VALUES
('a0000006'),
('a0000007'),
('a0000008'),
('a0000009'),
('a0000010'),
('a0000011'),
('a0000012'),
('a0000013'),
('a0000014'),
('a1111114'),
('a1234567'),
('a1238889'),
('a8456894');

--
-- Дамп данных таблицы `studentanswers`
--

INSERT INTO `studentanswers` (`StudentAttempt_StudentAttemptId`, `Alternative_alternativeId`) VALUES
(3, 1),
(3, 6),
(3, 10),
(4, 1),
(4, 5),
(4, 11),
(5, 1),
(5, 8),
(5, 11),
(6, 1),
(6, 5),
(6, 11),
(7, 2),
(7, 6),
(7, 11),
(8, 1),
(8, 6),
(8, 12),
(9, 1),
(9, 6),
(9, 11),
(10, 2),
(10, 6),
(10, 11),
(11, 3),
(11, 6),
(11, 11),
(12, 4),
(12, 5),
(12, 11);

--
-- Дамп данных таблицы `studentattempt`
--

INSERT INTO `studentattempt` (`Student_studentNumber`, `attemptDate`, `Quizz_quizzId`, `StudentAttemptId`, `Result`) VALUES
('a0000006', '2014-05-08 15:38:02', 3, 3, 0),
('a0000007', '2014-05-08 15:46:00', 3, 4, 0),
('a0000008', '2014-05-08 15:59:59', 3, 5, 67),
('a0000009', '2014-05-08 16:00:42', 3, 6, 67),
('a0000010', '2014-05-08 16:34:56', 3, 7, 67),
('a0000011', '2014-05-08 16:48:20', 3, 8, 67),
('a0000012', '2014-05-08 20:17:20', 3, 9, 100),
('a0000013', '2014-05-08 23:32:55', 3, 10, 67),
('a0000014', '2014-05-08 23:33:40', 3, 11, 67),
('a1111114', '2014-05-09 07:17:58', 3, 12, 33);

--
-- Дамп данных таблицы `teacher`
--

INSERT INTO `teacher` (`teacherId`, `username`, `password`, `firstName`, `lastName`) VALUES
(4, 'teacher', 'teacher', 'pekka', 'makinen');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
