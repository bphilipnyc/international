package com.tpwp.international;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CloudController {

    @ResponseBody
    @GetMapping("cloud")
    public String getGoogleTranslate() {

        Translate translate = TranslateOptions.getDefaultInstance().getService();

        String textToTranslate = "Hello, world! Llama socks.    Quarter Pounder with Cheese.";

        Translation translation =
                translate.translate(
                        textToTranslate,
                        Translate.TranslateOption.sourceLanguage("en"),
                        Translate.TranslateOption.targetLanguage("fr"));


        System.out.printf("Text: %s%n", textToTranslate);
        System.out.printf("Translation: %s%n", translation.getTranslatedText());

        return translation.getTranslatedText();
    }
}
