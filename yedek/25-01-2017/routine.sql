/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cari_fisler_after_ins_tr` AFTER INSERT ON `cari_fisler` FOR EACH ROW BEGIN

IF (NEW.FIS_LEVEL = 0) and (NEW.FIS_TURU in (1,2,3,4,5,6,7,8,9,13,17,18,20)) THEN

  IF (NEW.ISARET = 0) THEN
	 UPDATE cari_hesaplar_bakiye SET BAKIYE = IFNULL(BAKIYE,0) + NEW.FIS_GTOPLAM,
								 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE REF_CARI = NEW.MUSTERI_REF;                                                                    
  END IF;
  
  IF (NEW.ISARET = -1) THEN
	 UPDATE cari_hesaplar_bakiye SET BAKIYE = IFNULL(BAKIYE,0) - NEW.FIS_GTOPLAM,
								 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE REF_CARI = NEW.MUSTERI_REF;  
  END IF;  

END IF;


IF (NEW.FIS_LEVEL <> 0) and (NEW.FIS_TURU in (3,4,5,7,9,10,11,12,17,18)) THEN

  IF (NEW.ISARET = -1) THEN
	 UPDATE urunler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) + (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
				 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);
                                 
	 UPDATE subeler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) + (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
				 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE SUBE_REF = NEW.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);
                                 
  END IF;
  
  IF (NEW.ISARET = 0) THEN
	 UPDATE urunler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) - (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
								 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);

	 UPDATE subeler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) - (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
								 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE SUBE_REF = NEW.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);
                                 
  END IF;  
 
END IF;

IF (NEW.FIS_LEVEL <> 0) and (NEW.FIS_TURU in (14)) THEN

  IF (NEW.ISARET = -1) THEN
	 UPDATE subeler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) - (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
				 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE SUBE_REF = NEW.MUSTERI_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);    
                                 
	 UPDATE subeler_bakiye SET BAKIYE = IFNULL(BAKIYE,0) + (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI),
				 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE<0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
                                 WHERE SUBE_REF = NEW.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);  
                                 
  END IF;   
 
END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cari_fisler_after_upd_tr` AFTER UPDATE ON `cari_fisler` FOR EACH ROW BEGIN
					   
IF (OLD.FIS_LEVEL = 0) and (OLD.FIS_TURU in (1,2,3,4,5,6,7,8,9,13,17,18,20)) THEN

	CASE NEW.ISARET
 	 WHEN 0 THEN BEGIN SET @oP = '+'; SET @nOP = '-'; END;
	 WHEN -1 THEN BEGIN SET @oP = '-'; SET @nOP = '+'; END;
	END CASE;

	IF (OLD.MUSTERI_REF <> NEW.MUSTERI_REF) THEN 

 	 UPDATE cari_hesaplar_bakiye SET BAKIYE = BAKIYE + concat(@nOP, OLD.FIS_GTOPLAM) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE REF_CARI = OLD.MUSTERI_REF; 	  	

 	 UPDATE cari_hesaplar_bakiye SET BAKIYE = BAKIYE + concat(@oP , NEW.FIS_GTOPLAM) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE REF_CARI = NEW.MUSTERI_REF; 	  	

	END IF;

	IF (OLD.MUSTERI_REF = NEW.MUSTERI_REF) THEN 

    	UPDATE cari_hesaplar_bakiye SET BAKIYE = (BAKIYE + concat(@nOP , OLD.FIS_GTOPLAM)) + concat(@oP , NEW.FIS_GTOPLAM) ,
   	    ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	    WHERE REF_CARI = OLD.MUSTERI_REF;      

    END IF;  

END IF;

IF (OLD.FIS_LEVEL <> 0) and (OLD.FIS_TURU in (3,4,5,7,9,10,11,12,17,18)) THEN
	
    CASE NEW.ISARET
 	 WHEN 0 THEN BEGIN SET @oP = '+'; SET @nOP = '-'; END;
	 WHEN -1 THEN BEGIN SET @oP = '-'; SET @nOP = '+'; END;
	END CASE;

	IF (OLD.URUN_REF <> NEW.URUN_REF) THEN 

 	 UPDATE urunler_bakiye SET BAKIYE = BAKIYE + concat(@nOP, (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF); 	  	

 	 UPDATE urunler_bakiye SET BAKIYE = BAKIYE + concat(@oP , (NEW.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@nOP, (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF); 	  	

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@oP , (NEW.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = NEW.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF); 	  	

	END IF;

	IF (OLD.URUN_REF = NEW.URUN_REF) THEN 

    	UPDATE urunler_bakiye SET BAKIYE = (BAKIYE + concat(@nOP , (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI))) + concat(@oP , (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI)) ,
   	    ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	    WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

    	UPDATE subeler_bakiye SET BAKIYE = (BAKIYE + concat(@nOP , (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI))) + concat(@oP , (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI)) ,
   	    ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	    WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

    END IF;  

END IF;

IF (OLD.FIS_LEVEL <> 0) and (OLD.FIS_TURU in (14)) THEN
	
    CASE NEW.ISARET
 	 WHEN 0 THEN BEGIN SET @oP = '+'; SET @nOP = '-'; END;
	 WHEN -1 THEN BEGIN SET @oP = '-'; SET @nOP = '+'; END;
	END CASE;

	IF (OLD.URUN_REF <> NEW.URUN_REF) THEN 

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@nOP, (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = OLD.MUSTERI_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@oP , (NEW.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = NEW.MUSTERI_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@nOP, (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

 	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + concat(@oP , (NEW.LINE_MIKTAR * OLD.LINE_KATSAYI)) ,
	 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	 WHERE SUBE_REF = NEW.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = NEW.URUN_REF);

	END IF;

	IF (OLD.URUN_REF = NEW.URUN_REF) THEN 

    	UPDATE subeler_bakiye SET BAKIYE = (BAKIYE + concat(@nOP , (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI))) + concat(@oP , (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI)) ,
   	    ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	    WHERE SUBE_REF = OLD.MUSTERI_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

    	UPDATE subeler_bakiye SET BAKIYE = (BAKIYE + concat(@nOP , (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI))) + concat(@oP , (NEW.LINE_MIKTAR * NEW.LINE_KATSAYI)) ,
   	    ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
	    WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

    END IF;  

END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `cari_fisler_after_del_tr` AFTER DELETE ON `cari_fisler` FOR EACH ROW BEGIN

IF (OLD.FIS_LEVEL = 0) and (OLD.FIS_TURU in (1,2,3,4,5,6,7,8,9,13,17,18,20)) THEN

  IF (OLD.ISARET = 0) THEN
	 UPDATE cari_hesaplar_bakiye SET BAKIYE = BAKIYE - OLD.FIS_GTOPLAM ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE REF_CARI = OLD.MUSTERI_REF;  

  END IF;
  
  IF (OLD.ISARET = -1) THEN
	 UPDATE cari_hesaplar_bakiye SET BAKIYE = BAKIYE + OLD.FIS_GTOPLAM ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE REF_CARI = OLD.MUSTERI_REF;  

  END IF; 

END IF;                             


IF (OLD.FIS_LEVEL <> 0) and (OLD.FIS_TURU in (3,4,5,7,9,10,11,12,17,18)) THEN

  IF (OLD.ISARET = -1) THEN
	 UPDATE urunler_bakiye SET BAKIYE = BAKIYE - (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE - (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

  END IF;
  
  IF (OLD.ISARET = 0) THEN
	 UPDATE urunler_bakiye SET BAKIYE = BAKIYE + (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE REF_STOK = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

  END IF; 
END IF;  
  
IF (OLD.FIS_LEVEL <> 0) and (OLD.FIS_TURU in (14)) THEN

  IF (OLD.ISARET = -1) THEN
	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE - (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE SUBE_REF = OLD.SUBE_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

	 UPDATE subeler_bakiye SET BAKIYE = BAKIYE + (OLD.LINE_MIKTAR * OLD.LINE_KATSAYI) ,
							 ISARET = IF(BAKIYE > 0,'+',IF(BAKIYE < 0,'-','')), AB = IF(BAKIYE > 0,'(B)',IF(BAKIYE<0,'(A)',''))
							 WHERE SUBE_REF = OLD.MUSTERI_REF and STOK_REF = (select IF(URUN_PID = 0,URUN_ID,URUN_PID) URUN_REF  from urunler where URUN_ID = OLD.URUN_REF);

  END IF;
    
END IF; 

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `subeler_after_ins_tr` AFTER INSERT ON `subeler` FOR EACH ROW BEGIN
 INSERT INTO `subeler_bakiye` (`SUBE_REF`,`STOK_REF`,`BAKIYE`,`AB`,`ISARET`)
 SELECT NEW.SUBE_ID, REF_STOK,"0","","" FROM `urunler_bakiye`; 
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `subeler_after_del_tr` AFTER DELETE ON `subeler` FOR EACH ROW BEGIN
 DELETE FROM subeler_bakiye where SUBE_REF = OLD.SUBE_ID;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `urunler_after_ins_tr` AFTER INSERT ON `urunler` FOR EACH ROW BEGIN
 IF NEW.URUN_PID = 0 THEN
 INSERT INTO urunler_bakiye (REF_STOK,BAKIYE,AB,ISARET) VALUES
 							   (NEW.URUN_ID,0,'','');
                               
 INSERT INTO `subeler_bakiye` (`SUBE_REF`,`STOK_REF`,`BAKIYE`,`AB`,`ISARET`)
 SELECT SUBE_ID, NEW.URUN_ID,"0","","" FROM `subeler`;                               
 
 END IF;							   

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`system`@`%`*/ /*!50003 FUNCTION `barkodNoTerazi_fun`(
        _NO VARCHAR(15)
    ) RETURNS varchar(15) CHARSET latin5
    READS SQL DATA
    DETERMINISTIC
BEGIN
 declare defSayac, maxstokNo, yeniNo TEXT;
   
 set defSayac = _NO;

 SELECT MAX(BARKOD_ID) YENI_STOK_NO into maxstokNo from urunler
 WHERE BARKOD_ID like concat(substr(defSayac,1,1),'%')
 AND BARKOD_TIP = 'TERAZİ';

 IF maxstokNo <> '' THEN
  set yeniNo = NUMARATOR(maxstokNo);
 ELSE
  set yeniNo = defSayac;
 END IF;

 RETURN yeniNO;
 
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`system`@`%`*/ /*!50003 FUNCTION `barkodNo_fun`(
        _NO VARCHAR(15)
    ) RETURNS varchar(15) CHARSET latin5
    READS SQL DATA
    DETERMINISTIC
BEGIN
 declare defSayac, maxstokNo, yeniNo TEXT;
   
 set defSayac = _NO;

 SELECT MAX(BARKOD_ID) YENI_STOK_NO into maxstokNo from urunler
 WHERE BARKOD_ID like concat(substr(defSayac,1,1),'%')
 AND BARKOD_TIP = 'ARTİKEL';

 IF maxstokNo <> '' THEN
  set yeniNo = NUMARATOR(maxstokNo);
 ELSE
  set yeniNo = defSayac;
 END IF;

 RETURN yeniNO;
 
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50020 DEFINER=`system`@`%`*/ /*!50003 FUNCTION `NUMARATOR`(
        `fisno` VARCHAR(15)
    ) RETURNS varchar(15) CHARSET latin5
    NO SQL
    DETERMINISTIC
BEGIN
declare  nmr, temp, temp1 text default '';
declare i, tmp, say, sayA int;

set nmr = REVERSE(fisno);

set i = 0;
set say = 0;
set sayA = 0;

while i < length(fisno) Do

set i = i + 1;

IF substr(nmr,i,1) = '9' THEN
set nmr = right(nmr, length(fisno));
set nmr = insert (nmr,i,1,'0');
set say = say + 1;
ELSEIF substr(nmr,i,1) < '9' and substr(nmr,i,1) >= '0' THEN
set temp = unhex(hex(substr(nmr,i,1))+1);

set tmp = i;
set i = length(fisno);

ELSE

IF substr(nmr,i,1) = 'Z' THEN
set nmr = right(nmr, length(fisno));
set nmr = insert (nmr,i,1,'A');
set sayA = sayA + 1;

ELSEIF substr(nmr,i,1) < 'Z' and substr(nmr,i,1) >= 'A' THEN
set temp = unhex(hex(substr(nmr,i,1))+1);
set tmp = i;
set i = length(fisno);
END IF;
END IF;

END WHILE;

set i = 0;
while i < length(fisno) Do
set i = i + 1;

IF tmp = i THEN
set nmr = concat(LEFT(nmr,i-1),substr(temp,1),substr(nmr,i+1,length(fisno)));
END IF;

END WHILE;

if length(fisno) = say then set nmr = concat (nmr,'1'); END IF;
if length(fisno) = sayA then set nmr = concat (nmr,'A'); END IF;

RETURN  REVERSE(nmr);


END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
