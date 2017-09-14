package org.ditto.emoji.data;

import lombok.extern.slf4j.Slf4j;
import org.apache.ignite.Ignite;
import org.ditto.emoji.model.Gif;
import org.ditto.emoji.model.Gifgroup;
import org.ditto.emoji.repository.GifRepository;
import org.ditto.emoji.repository.GifgroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 服务启动执行
 */
@Component
@Slf4j
public class GifDataImportRunner implements CommandLineRunner {

    @Autowired
    private Ignite ignite;
    @Autowired
    private GifgroupRepository gifgroupRepository;
    @Autowired
    private GifRepository gifRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Start GifDataImportRunner服务启动执行，执行Gif数据导入");
        List<Object> emojiDatas = GifTextConverter.processGifText(GifText.emojiLines);
        for (Object emojiData : emojiDatas) {
            if (emojiData instanceof Gifgroup) {
                Gifgroup gifgroup = (Gifgroup) emojiData;
                gifgroupRepository.save(gifgroup.id, gifgroup);
            } else if (emojiData instanceof Gif) {
                Gif gif = (Gif) emojiData;
                gifRepository.save(gif.codepoint, gif);
            }
        }
        log.info("End   GifDataImportRunner服务启动执行，执行Gif数据导入");
    }
}
