package com.demo.service;


import com.demo.dto.ShopDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

@Service
@Log4j2
public class MainMailService {

    private final String SEND_EMAIL_FROM = "sbm0709@naver.com";

    @Autowired
    private JavaMailSender javaMailSender;


    private void sendMail(String to,List<ShopDTO> shopList) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(SEND_EMAIL_FROM);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject("조회된 상점 결과");
        if(shopList.isEmpty()){
            mimeMessageHelper.setText("<h1>조회된 데이터가 없습니다.</h1>",true);
        }
        else {
            StringBuilder text = new StringBuilder();
            for (ShopDTO shop: shopList) {
                text.append(shop.getShopName()).append("\t").append(shop.getDistrictName()).append("\t").append(shop.getViewCount()).append("\n");
            }
            mimeMessageHelper.setText(text.toString());
        }
        javaMailSender.send(mimeMessage);
    }

    public void send(String email, List<ShopDTO> shopList){

        try {
            sendMail(email, shopList);
        }
        catch (Exception e){
            log.error("send Error : "+ e);
        }
    }
}
