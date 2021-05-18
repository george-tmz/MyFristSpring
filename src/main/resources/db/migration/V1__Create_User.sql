CREATE TABLE `user`
(
    `id`                 bigint unsigned NOT NULL AUTO_INCREMENT,
    `username`           varchar(20) COLLATE utf8mb4_general_ci  NOT NULL,
    `encrypted_password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `avatar`             varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `created_at`         datetime                                DEFAULT NULL,
    `updated_at`         datetime                                DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;