package com.test.service;

import com.test.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class MessageServiceImpl implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    public void save(Message message) {
        BufferedWriter bufferedWriter = null;
        String string = "";

        String str = message.getTitle();
        String[] s = str.split(" ");
        for (String ss : s) {
            if (ss.charAt(0) == 'a') {
                string = string + " " + ss;
            }
        }
        try {
            File file = new File("C:\\Users\\marat.bagdasaryan\\Desktop\\FileTesting\\test.txt");
            Writer writer = new FileWriter(file);
            bufferedWriter = new BufferedWriter(writer);
            writer.write(string);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                logger.warn(e.getMessage());
            }
        }
    }

    public void copy() {
        BufferedInputStream in = null;
        BufferedOutputStream out = null;
        try {
            FileOutputStream outputStream = new FileOutputStream(
                    new File("C:\\Users\\marat.bagdasaryan\\Desktop\\FileTesting\\out.txt"));
            FileInputStream inputStream = new FileInputStream(
                    new File("C:\\Users\\marat.bagdasaryan\\Desktop\\FileTesting\\in.txt"));
            in = new BufferedInputStream(inputStream);
            out = new BufferedOutputStream(outputStream);
            while ((in.read()) != -1) {
                out.write(in.read());
            }
        } catch (IOException e) {
            logger.warn(e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                logger.warn(e.getMessage());
            }
        }
    }
}