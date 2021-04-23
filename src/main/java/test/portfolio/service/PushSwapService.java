package test.portfolio.service;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PushSwapService implements ProjectService{
    @Override
    public String exec(String params) {
        Runtime runtime = Runtime.getRuntime();
        Process process = null;
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        String test = "";
        try {
            process = runtime.exec("/home/hlopec1993/Push_swap/push_swap " + params);
            process.waitFor();
        } catch (Exception e) {
            test = e.toString();
        }
        if (process != null){
            InputStream inputStream = process.getInputStream();
            byte[] buff = new byte[1024];
            int readBytes;
            try {
                while (inputStream.available() > 0){
                    readBytes = inputStream.read(buff, 0, 1024);
                    result.write(buff, 0, readBytes);
                }
            } catch (Exception e){
            }

        }
        if (test.isEmpty()) {
            test = result.toString();
        }
        Gson gson = new Gson();
        return gson.toJson(test.split("\n"));
    }
}
