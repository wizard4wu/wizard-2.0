

create table my_user(
 `id` INT UNSIGNED auto_increment,
 `name` varchar(32) default null,
 `email` varchar(32) not null default '',
 `age` tinyint(8) not null default "0",
 `phone_number` varchar(11) not null default '',
 `sex` tinyint(3) not null default "0",
 `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;