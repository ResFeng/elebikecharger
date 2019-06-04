package net.chenlin.dp.modules.sc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Map;

@Controller
@RequestMapping("/image")
public class ScQrCodeController {

    /**
     * @param params
     * @return
     */
    @RequestMapping(value = "/getQrCode",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public BufferedImage getQrCode(@RequestBody Map<String, String> params) throws IOException{
        String outletId = params.get("outletid");
        String serialId = params.get("serialid");
        String path = "D:/CV/O-"+outletId+"/O-"+outletId+"-"+serialId+".jpg";
        return ImageIO.read(new FileInputStream(new File(path)));
    }
}
