CREATE TABLE IF NOT EXISTS `EXPORT_MATERIALDETAIL` (
  `EXPORT_MATERIALDETAILID` int(100) NOT NULL AUTO_INCREMENT,
  `EXPORT_MATERIALID` int(100) NOT NULL,
  `MATERIALID` int(100) NOT NULL,
  `EXPORT_QUANTITY` int(100) NOT NULL,
   PRIMARY KEY (`EXPORT_MATERIALDETAILID`),
    foreign key (MATERIALID) references MATERIAL(MATERIALID),
    foreign key (EXPORT_MATERIALID) references EXPORT_MATERIAL(EXPORT_MATERIALID) 
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=0;