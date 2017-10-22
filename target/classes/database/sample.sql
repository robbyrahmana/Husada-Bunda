-- t_room_category
INSERT INTO t_room_category (ID,cd,createDate,dscp,isDel,name,updateDate) VALUES ('7f554d7a-3c5d-4c15-921d-fa4b4c629e6c','KLS2','2017-06-15 22:01:08',NULL,'0','Kelas 2',NULL);
INSERT INTO t_room_category (ID,cd,createDate,dscp,isDel,name,updateDate) VALUES ('aab56514-ca13-4659-8736-e8742c7de1b3','KLS1','2017-06-15 22:00:22',NULL,'0','Kelas 1',NULL);
INSERT INTO t_room_category (ID,cd,createDate,dscp,isDel,name,updateDate) VALUES ('cc7148ab-c531-4859-a8a4-7b22ff345603','KLS3','2017-06-15 22:01:30',NULL,'0','Kelas 3',NULL);

-- t_room_details
INSERT INTO t_room_details (ID,cd,cost,createDate,dscp,isDel,name,updateDate,room_category_id) VALUES ('56f92e29-29cf-44c8-9c2e-cd2b5d3edd7b','202','1000','2017-07-09 20:05:28',NULL,'0','Ruang Edelwis',NULL,'aab56514-ca13-4659-8736-e8742c7de1b3');
INSERT INTO t_room_details (ID,cd,cost,createDate,dscp,isDel,name,updateDate,room_category_id) VALUES ('5cfc96f4-c05a-461c-bb5d-6ee61f65d9de','203','1000','2017-07-09 20:05:50',NULL,'0','Ruang Mawar',NULL,'7f554d7a-3c5d-4c15-921d-fa4b4c629e6c');

-- t_room_bed
INSERT INTO t_room_bed (ID,cd,createDate,dscp,isAvailable,isDel,updateDate,room_detail_id) VALUES ('5a22ccaf-89a0-4fbf-9474-5dd3b20fdf31','2021','2017-07-09 20:47:11',NULL,'1','0',NULL,'56f92e29-29cf-44c8-9c2e-cd2b5d3edd7b');
INSERT INTO t_room_bed (ID,cd,createDate,dscp,isAvailable,isDel,updateDate,room_detail_id) VALUES ('93d772b6-b511-4b08-8cbf-b8555f42346d','2031','2017-07-09 20:46:57',NULL,'1','0',NULL,'5cfc96f4-c05a-461c-bb5d-6ee61f65d9de');

-- t_desease
INSERT INTO t_desease (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('c3115e61-d89b-46de-ad14-969cd0112b43','P.101','2017-07-09 22:37:26','0','Diare',NULL,NULL);

-- t_functionality

-- t_medicine
INSERT INTO t_medicine (ID,cd,createDate,isDel,name,remark,updateDate,base_unit_id) VALUES ('231e9ca5-dfbc-46ac-b4de-913997d4340f','M.102','2017-07-10 19:34:53','0','Panadol',NULL,NULL,'15c58187-8499-4db9-bfb0-b707cf441bed');
INSERT INTO t_medicine (ID,cd,createDate,isDel,name,remark,updateDate,base_unit_id) VALUES ('f80a7f48-65c0-4af0-87a0-8d1fd7d157c3','M.101','2017-07-10 19:34:23','0','Bodrex','',NULL,'15c58187-8499-4db9-bfb0-b707cf441bed');
