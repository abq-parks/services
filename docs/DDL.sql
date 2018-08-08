create sequence hibernate_sequence start with 1 increment by 1;

create table amenity (amenity_id bigint not null,
 display_name varchar(255) not null,
 name varchar(255) not null,
 primary key (amenity_id));

create table park (park_id bigint not null,
 latitude double not null,
 longitude double not null,
 name varchar(100) not null,
 primary key (park_id));

create table park_amenities (park_id bigint not null,
 amenity_id bigint not null);

create table park_reviews (park_park_id bigint not null,
 reviews_review_id bigint not null);

create table review (review_id bigint not null,
 date date not null,
 review varchar(255) not null,
 park_id bigint not null,
 user_id bigint not null,
 primary key (review_id));

create table users (user_id bigint not null,
 first_name varchar(255),
 googleid varchar(255) not null,
 last_name varchar(255),
 user_email varchar(255),
 primary key (user_id));

alter table park_reviews add constraint UK_7dcdwlhh71ijfqwgctytdanyq unique (reviews_review_id);
alter table park_amenities add constraint FKcagna3q7miirfxwoe6g4ucbig foreign key (amenity_id) references amenity;
alter table park_amenities add constraint FKr3495bmmvtrbx1rj008r74f7q foreign key (park_id) references park;
alter table park_reviews add constraint FK2m6pq3uumk35raviw15bhipq5 foreign key (reviews_review_id) references review;
alter table park_reviews add constraint FKrhr6grhh9gae0m306h37cunxv foreign key (park_park_id) references park;
alter table review add constraint FK6nr7t1hxbh4i3ftbbto3b7lpa foreign key (park_id) references park;
alter table review add constraint FK6cpw2nlklblpvc7hyt7ko6v3e foreign key (user_id) references users;
