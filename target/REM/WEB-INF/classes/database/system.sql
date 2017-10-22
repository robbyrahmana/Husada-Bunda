-- tbl_sec_user_roles
INSERT INTO tbl_sec_roles (ID,ROLE) VALUES ('3c3017b4-48eb-11e7-954d-02004e435049','ROLE_APP');

-- t_mt_status
INSERT INTO t_mt_status (ID,cd,dscp,segNo) VALUES ('b238fe40-5037-11e7-b7c8-02004e435049','NEW','New',10);
INSERT INTO t_mt_status (ID,cd,dscp,segNo) VALUES ('c5c795d5-5037-11e7-b7c8-02004e435049','CWD','Consult With Doctor',20);
INSERT INTO t_mt_status (ID,cd,dscp,segNo) VALUES ('dbed4254-5037-11e7-b7c8-02004e435049','CMC','Collect Medicine',30);
INSERT INTO t_mt_status (ID,cd,dscp,segNo) VALUES ('ea29ee5f-5037-11e7-b7c8-02004e435049','OPN','Open',50);
INSERT INTO t_mt_status (ID,cd,dscp,segNo) VALUES ('f849a4bf-5037-11e7-b7c8-02004e435049','CMP','Complete',100);

-- t_mt_golongan_darah
INSERT INTO t_mt_golongan_darah (ID,bloodgroup,createDate,isDel,updateDate) VALUES ('1b6ea85a-b9b2-40a7-a58c-5442bcf2fabf','O','2017-07-09 11:54:51','0',NULL);
INSERT INTO t_mt_golongan_darah (ID,bloodgroup,createDate,isDel,updateDate) VALUES ('b011bb0e-4e6e-477a-a414-a689ceeda9a1','A','2017-07-09 11:54:34','0',NULL);
INSERT INTO t_mt_golongan_darah (ID,bloodgroup,createDate,isDel,updateDate) VALUES ('c36184b2-5aa8-44b4-abe9-b54da4dd8729','B','2017-07-09 11:54:39','0',NULL);
INSERT INTO t_mt_golongan_darah (ID,bloodgroup,createDate,isDel,updateDate) VALUES ('f80a6d2e-8693-44f9-94a1-e924e025c8dc','AB','2017-07-09 11:54:45','0',NULL);

-- t_mt_insurance
INSERT INTO t_mt_insurance (ID,createDate,insurance,isDel,remark,updateDate) VALUES ('716d04ce-255c-42e3-a4ac-af4555be8309','2017-07-09 11:58:06','BPJS (Badan Penyelenggara Jaminan Sosial)',0,NULL,NULL);

-- t_mt_work
INSERT INTO t_mt_work (ID,createDate,isDel,updateDate,work) VALUES ('912958ac-a478-4f51-bda7-1109fd8e3319','2017-08-10 22:44:37',0,NULL,'Ibu Rumah Tangga');

-- t_mt_relationship
INSERT INTO t_mt_relationship (ID,createDate,isDel,relationship,updateDate) VALUES ('bad18ee8-3a88-4d31-8361-ad3ae6502b94','2017-08-10 22:43:58',0,'Menikah',NULL);
INSERT INTO t_mt_relationship (ID,createDate,isDel,relationship,updateDate) VALUES ('c2f3290f-39f7-43fb-b568-24be24ca26f3','2017-08-10 22:43:51',0,'Lajang',NULL);

-- t_mt_rhesus
INSERT INTO t_mt_rhesus (ID,createDate,isDel,rhesus,updateDate) VALUES ('238f58b5-3587-4b63-ab5f-201a649ff89f','2017-08-10 22:44:08',0,'Rh+',NULL);
INSERT INTO t_mt_rhesus (ID,createDate,isDel,rhesus,updateDate) VALUES ('3addc88c-7263-4075-a3d6-60776451d7cd','2017-08-10 22:44:15',0,'Rh-',NULL);

-- t_mt_indentity
INSERT INTO t_mt_indentity (ID,createDate,identity,isDel,updateDate) VALUES ('24d83191-591e-4b1a-9929-60bccf5555b4','2017-08-10 22:43:40','SIM',0,NULL);
INSERT INTO t_mt_indentity (ID,createDate,identity,isDel,updateDate) VALUES ('d97613ae-1de2-4443-a8e0-6cbab2d598d9','2017-08-10 22:43:34','KTP',0,NULL);

-- t_mt_title
INSERT INTO t_mt_title (ID,createDate,isDel,remark,title,updateDate) VALUES ('0b04a211-ca9c-46ab-a712-0682f864e36a','2017-07-09 11:51:48','0',NULL,'Ny.',NULL);
INSERT INTO t_mt_title (ID,createDate,isDel,remark,title,updateDate) VALUES ('5539f7c9-1c87-47f5-8739-4f0298aca3f5','2017-07-09 11:58:56','0',NULL,'Dr.',NULL);
INSERT INTO t_mt_title (ID,createDate,isDel,remark,title,updateDate) VALUES ('838eac95-3a90-4b5c-ac5e-99517048375a','2017-07-09 11:51:39','0',NULL,'Tn.',NULL);
INSERT INTO t_mt_title (ID,createDate,isDel,remark,title,updateDate) VALUES ('8ea05e21-9759-49b2-92d4-05fdd9a38710','2017-07-09 11:58:44','0',NULL,'By.',NULL);

-- t_mt_religion
INSERT INTO t_mt_religion (ID,createDate,isDel,religion,updateDate) VALUES ('083dbec1-72cf-4ae5-b1ac-5b4650426809','2017-07-09 11:56:04','0','Hindu',NULL);
INSERT INTO t_mt_religion (ID,createDate,isDel,religion,updateDate) VALUES ('2443417d-e879-4876-bf92-0cfe9ba854ea','2017-07-09 11:56:13','0','Buddha',NULL);
INSERT INTO t_mt_religion (ID,createDate,isDel,religion,updateDate) VALUES ('9aef6cfa-e5bf-4c6c-bea9-73412f565cc7','2017-07-09 11:57:31','0','Konghucu',NULL);
INSERT INTO t_mt_religion (ID,createDate,isDel,religion,updateDate) VALUES ('a61696b6-d45b-45ab-8160-85ecc8969615','2017-07-09 11:55:36','0','Islam',NULL);
INSERT INTO t_mt_religion (ID,createDate,isDel,religion,updateDate) VALUES ('d4bac759-3ff2-41b1-8272-579c8d24f26b','2017-07-09 11:55:53','0','Kristen',NULL);

-- t_mt_gender
INSERT INTO t_mt_gender (ID,createDate,gender,isDel,updateDate) VALUES ('358a9742-b713-45a1-82b7-aeaea0bb4314','2017-07-09 11:55:26','Laki-Laki','0',NULL);
INSERT INTO t_mt_gender (ID,createDate,gender,isDel,updateDate) VALUES ('dc04d422-46dc-4dc1-a3eb-ddafa51268a5','2017-07-09 11:55:18','Perempuan','0',NULL);

-- t_mt_insurance
INSERT INTO t_mt_insurance (ID,createDate,insurance,isDel,remark,updateDate) VALUES ('716d04ce-255c-42e3-a4ac-af4555be8309','2017-07-09 11:58:06','BPJS (Badan Penyelenggara Jaminan Sosial)','0',NULL,NULL);

-- t_mt_unit
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('15c58187-8499-4db9-bfb0-b707cf441bed','2017-07-10 19:12:20','0',NULL,'Kaplet',NULL);
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('1ce8c497-ad97-4d92-a98b-39c62e8fd37f','2017-07-10 19:03:44','0',NULL,'Botol',NULL);
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('4a0a9462-c745-43de-ab97-d0261e48a655','2017-07-10 19:04:23','0',NULL,'Kotak',NULL);
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('51e440a4-f5a1-4090-aad5-62daee540d1e','2017-07-10 19:03:29','0',NULL,'Tablet',NULL);
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('b2aa9bd0-afa3-474e-bf00-56f5ec06cf52','2017-07-10 19:21:54','0',NULL,'Papan',NULL);
INSERT INTO t_mt_unit (ID,createDate,isDel,remark,unit,updateDate) VALUES ('e04ad480-c54e-4656-8aec-dd4669fbacca','2017-07-10 18:48:33','0',NULL,'Kapsul',NULL);

-- t_treatment_header
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('0d9ba85a-fcdd-4320-a406-1ec9546f0aea','00005','2017-07-19 23:55:56','0','Biaya Obat-Obatan',NULL,'1','0',NULL);
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('0e2d8d60-b4fd-44a7-80fd-ce9982940a60','00002','2017-07-19 23:53:47','0','Biaya Tindakan',NULL,'1','1',NULL);
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('510da1bb-96ef-4051-8e04-9367e92604f7','00003','2017-07-19 23:54:17','0','Biaya Keperluan Operasi',NULL,'1','0',NULL);
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('54d98415-227d-4b1f-b8da-3c322ee758e0','00006','2017-07-19 23:56:22','0','Lain - Lain',NULL,'1','1',NULL);
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('a31c5055-bf5e-4350-9af1-f3471267bb52','00001','2017-07-19 23:53:12','0','Biaya Administrasi',NULL,'0','0',NULL);
INSERT INTO t_treatment_header (ID,cd,createDate,isDel,name,remark,showbody,is_choose_by_user,updateDate) VALUES ('acf1def0-4876-47f5-8a65-828da0f3bf84','00004','2017-07-19 23:54:55','0','Biaya Perawatan',NULL,'1','1',NULL);

-- t_treatment_body
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('02c6fc2d-3f63-4aac-bd38-856464acf5d3','06','2017-07-20 01:53:13','0','0','KAMAR TINDAKAN/INSTRUMEN',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('045288e5-c041-4052-8181-734eebe55e5f','02','2017-07-20 01:51:23','0','0','TINDAKAN PARTUS VACUM',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('12af8320-91d0-466f-bf04-d5ae2507e127','05','2017-07-20 01:52:27','0','0','TINDAKAN MANUAL',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('3396076a-e10c-45f4-b88e-30f0e5072693','10','2017-07-20 01:57:23','0','0','RESUSITASI BAYI',NULL,NULL,'510da1bb-96ef-4051-8e04-9367e92604f7');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('37229228-c829-42fa-8d82-1e45f6d8ecfb','04','2017-07-20 01:52:05','0','0','TINDAKAN CURETAGE',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('68b26dc8-84c6-45b4-987a-98097e068107','07','2017-07-20 01:56:03','0','0','KAMAR OPERASI',NULL,NULL,'510da1bb-96ef-4051-8e04-9367e92604f7');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('6d64a19e-0aad-44eb-9baf-fde349eb9220','08','2017-07-20 01:56:24','0','0','TIM OPERASI',NULL,NULL,'510da1bb-96ef-4051-8e04-9367e92604f7');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('7a957597-0039-4513-ad86-30e262e2aac6','01','2017-07-20 01:50:56','0','0','TINDAKAN PARTUS SPONTAN',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('bd435d83-2e90-42db-8e64-7ccd58d9ae01','11','2017-07-20 01:58:24','0','0','KAMAR RAWAT',NULL,NULL,'acf1def0-4876-47f5-8a65-828da0f3bf84');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('cb9c7845-4c03-49c7-aa27-30da23ea64b0','09','2017-07-20 01:56:44','0','0','ANASTHESI',NULL,NULL,'510da1bb-96ef-4051-8e04-9367e92604f7');
INSERT INTO t_treatment_body (ID,cd,createDate,isDel,cost,name,remark,updateDate,treatment_header_id) VALUES ('d4504529-cdc3-48d5-811d-f2fbb84fdbba','03','2017-07-20 01:51:46','0','0','TINDAKAN OPERASI SC',NULL,NULL,'0e2d8d60-b4fd-44a7-80fd-ce9982940a60');

-- t_smf
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('3bf207a1-ebd0-45f9-a792-0550c6b7c79f','SMF005','2017-08-15 19:39:15',0,'SMF. ANASTESI',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('50802306-2975-4552-8503-bb76926dddea','SMF006','2017-08-15 19:40:56',0,'SF. KEP/KEB',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('6f40519d-d9f2-4a89-b2cf-2e2bff72e06d','SMF002','2017-08-15 19:38:04',0,'SMF. BEDAH',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('75f6a318-e9c3-4c67-90a2-2339000954f9','SMF004','2017-08-15 19:38:39',0,'SMF. PENYAKIT DALAM',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('a4dd3024-c8d2-4957-880f-83e9fc6bfa52','SMF007','2017-08-15 19:41:21',0,'SF. FARMASI & ALKES',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('c93f2adb-cc45-4c28-af13-4df088b470ef','SMF003','2017-08-15 19:38:18',0,'SMF. ANAK',NULL,NULL);
INSERT INTO t_smf (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('d8e7905c-9405-4b15-8f79-9863585a35be','SMF001','2017-08-15 19:37:12',0,'SMF. KEBIDANAN',NULL,NULL);

-- t_position
INSERT INTO t_position (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('2da0a8c9-64f6-412a-891c-50a7603cfe87','P001','2017-08-13 18:47:40',0,'Dokter',NULL,NULL);
INSERT INTO t_position (ID,cd,createDate,isDel,name,remark,updateDate) VALUES ('42490459-a1ef-42f7-a6d0-ade6810d1747','P002','2017-08-13 21:48:38',0,'Perawat',NULL,NULL);
