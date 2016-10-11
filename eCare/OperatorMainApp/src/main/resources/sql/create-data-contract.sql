INSERT INTO `tproject`.`TARIFFS` (`id`, `name`, `price`) VALUES (211369877, 'testTariff1', 100);
INSERT INTO `tproject`.`TARIFFS` (`id`, `name`, `price`) VALUES (211369878, 'testTariff2', 300);
INSERT INTO `tproject`.`OPTIONS` (`id`, `initialPrice`, `name`, `price`) VALUES (214561783, 1000, 'testOption1', 500);
INSERT INTO `tproject`.`USERS` (`id`, `address`, `balance`, `birthday`, `email`, `login`, `name`, `passport`, `password`, `surname`, `role`) VALUES (299999998, 'address', 500, '1992-04-14', 'jamesbrown@mail.ru', '1poi3JUShN76c', 'James', 'passport', 'password', 'Brown', 2);
INSERT INTO `tproject`.`CONTRACTS` (`id`, `isBlocked`, `number`, `tariff_id`, `user_id`) VALUES (213698745, 0, 2030508090, 211369877, 299999998);
INSERT INTO `tproject`.`CONTRACTS` (`id`, `isBlocked`, `number`, `tariff_id`, `user_id`) VALUES (213698746, 0, 2030508091, 211369877, 299999998);


