--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `name` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `id` SERIAL PRIMARY KEY NOT NULL
);

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`name`, `lastname`, `email`, `id`) VALUES
('Keith', 'Bond', 'dolor.tempus@pharetranibhAliquam.co.uk', 1),
('Johny', 'Michael', 'amway.trade@alibaba.com', 2),
('Driscoll', 'Rosa', 'ut@pretiumetrutrum.org', 3),
('Sanchez', 'Mayhem', 'augue.scelerisque@id.co.uk', 4),
('Malcolm', 'Simon', 'eu.odio.Phasellus@loremeumetus.com', 5),
('Elton', 'Bentley', 'tristique.aliquet@Ut.ca', 6),
('Tad', 'Daugird', 'tad.daugird@alus.com', 7),
('Andrew', 'Bread', 'nulla@consectetuer.edu', 8),
('Sancej', 'Gupta', 'indiansrole@show.edu', 9);

-- --------------------------------------------------------

--
-- Table structure for table `property_type`
--

CREATE TABLE `property_type` (
  `id` SERIAL PRIMARY KEY NOT NULL,
  `propertyType` varchar(255) NOT NULL,
  `taxRate` DOUBLE NOT NULL
);

--
-- Dumping data for table `property_type`
--

INSERT INTO `property_type` (`id`, `propertyType`, `taxRate`) VALUES
(1, 'Industrial', 1.12),
(2, 'Recreational', 1.25),
(3, 'Luxury', 1.32),
(4, 'Suburban', 1.20);


--
-- Table structure for table `building`
--


CREATE TABLE `building` (
  `id` SERIAL PRIMARY KEY NOT NULL,
  `city` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `number` smallint(11) NOT NULL,
  `size` double NOT NULL,
  `market_value` double NOT NULL,
  `property_type_id` integer references property_type(id),
  `owner_id` integer references owner(id)
);

--
-- Dumping data for table `building`
--

INSERT INTO `building` (`city`, `street`, `number`, `size`, `market_value`, `property_type_id`, `owner_id`) VALUES
('Acquasparta', 'Quis Avenue', 1, 250, 52000.25, 1, 8),
('Vottem', 'Consectetuer Road', 2, 125.75, 78000.47, 4, 6),
('Baracaldo', 'Dui Road', 3, 100.52, 99000.74, 3, 4),
('Concepcion', 'Velton Road', 4, 88.47, 49000.45, 1, 5),
('Gujranwala', 'Ridiculus Avenue', 5, 290, 12500.47, 3, 2),
('Langollen', 'Mollestie St.', 6, 320, 165000, 3, 7),
('Poederlee', 'Sit Avenue', 7, 245.74, 83000, 2, 3),
('Santa Clavia', 'Pellentesque Road', 8, 75, 26000, 1, 5),
('Goulburn', 'Tristique Avenue', 9, 143, 55000.45, 1, 2),
('Anghiari', 'Sed Ave', 10, 62, 85000, 3, 3);
