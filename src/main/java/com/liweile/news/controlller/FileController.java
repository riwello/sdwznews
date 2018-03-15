package com.liweile.news.controlller;

import com.liweile.news.model.FileInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/file")
@RestController
public class FileController {

    private String HOST = "http://10.0.2.2:8111";

    @RequestMapping("/filelist")
    public ResponseEntity<List<FileInfo>> getFileList(){
        List<FileInfo> fileInfoList =new ArrayList<>();

        String filePath = "D:/sdwzfiles";

        File fileDir = new File(filePath);
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }

        File[] files = fileDir.listFiles();
        for (File file : files) {

            String url =HOST+"/file//download?filename="+file.getName();
            FileInfo fileInfo = new FileInfo(file.getName(), file.length(),url);
            fileInfoList.add(fileInfo);
        }

        return new ResponseEntity<>(fileInfoList, HttpStatus.OK);
    }

    @RequestMapping("/download")
    public String downLoad(HttpServletResponse response,@RequestParam("filename")String filename) {

        String filePath = "D:/sdwzfiles";
        File file = new File(filePath + "/" + filename);
        if (file.exists()) { //判断文件父目录是否存在
            response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("----------file download" + filename);
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return null;
    }


}
