package com.modeul.web.service;

import java.io.UnsupportedEncodingException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

public interface MailService {

    // 메일내용 작성
    public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException;
    public String createKey();
    public String sendConfirmMessage(String to) throws Exception;
}
