package com.wisdom08.service.storage;

import com.wisdom08.dto.storage.IUpfile;


public interface IStorageService {

    // 파일 단 건 업로드
    void upload(IUpfile file);

}
