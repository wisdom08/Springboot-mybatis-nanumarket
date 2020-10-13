package com.wisdom08.controller.market;

import com.wisdom08.TypeMap;
import com.wisdom08.Util;
import com.wisdom08.dto.User;
import com.wisdom08.dto.storage.IUpfile;
import com.wisdom08.dto.storage.RemoteUpfile;
import com.wisdom08.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MarketController {

    @Autowired
    MarketService marketService;

    @PostMapping("/market/write")
    public Object sellProduct(@RequestParam String title,
                              @RequestParam String content,
                              @RequestParam List<MultipartFile> upfiles,
                              HttpSession session){

        User user = Util.getUser(session);
        if (user == null) {
            user = new User(1L, "a", "a@a.com", "****");
        }
        System.out.println(title);
        System.out.println(content);
        System.out.println(upfiles.size());
        for (MultipartFile f : upfiles) {
            System.out.println(f.getSize());
        }

        List<IUpfile> files = upfiles.stream().
                map(file -> new RemoteUpfile(file)).collect(Collectors.toList());
        marketService.insertProduct(user.getSeq(), title, content, files);
        return TypeMap.success();
    }
}
