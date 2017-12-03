CREATE TABLE `pet` (
  `id`   CHAR(36)     NOT NULL PRIMARY KEY,
  `shop_id` CHAR(36)     NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `pet_status` INT NOT NULL
);