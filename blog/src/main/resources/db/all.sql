CREATE TABLE `morrun_users` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_users_morrun_users_profile` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `user_id` int(11) NOT NULL,
  `user_profile_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_users_profile` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `type` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_blog` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `user_id` int(11) NOT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updata_date` timestamp NULL DEFAULT NULL,
  `like` int(11) DEFAULT 0,
  `unlike` int(11) DEFAULT 0,
  `type_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_blog_type` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_profiles` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `image` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_profiles_degrees` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `profile_id` int(11) NOT NULL,
  `school` varchar(255) NOT NULL,
  `degree` varchar(255) NOT NULL,
  `graduated_date` timestamp,
  `major` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_profiles_skills` (
  `id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  `profile_id` int(11) NOT NULL,
  `skills` varchar(255) NOT NULL,
  `rank` int(11) DEFAULT 5
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `morrun_comment` (
	`id` int(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `blog_id` int(11) NOT NULL,
    `content` text NOT NULL,
    `commenter_email` varchar(100) NOT NULL,
    `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	`updata_date` timestamp NULL DEFAULT NULL,
    `like` int(11) DEFAULT 0,
	`unlike` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

commit;
