package com.raheem.temperaturereader;

public class UIPage {

    public static String getHtmlCode(Double temperature) {
        return
                "\t<!DOCTYPE html>\n" +
                        "\t<html>\n" +
                        "\t<head>\n" +
                        "\t<meta http-equiv=\"refresh\" content=\"10\">\t" +
                        "\t\t<style>\n" +
                        "\t\t\t.container {\n" +
                        "\t\t\t\tposition: relative;\n" +
                        "\t\t\t\tpadding-left:10%;\n" +
                        "\t\t\t\twidth: 80%; /* adjust the width according to your image */\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.image {\n" +
                        "\t\t\t\twidth: 100%;\n" +
                        "\t\t\t}\n" +
                        "\n" +
                        "\t\t\t.text {\n" +
                        "\t\t\t\tposition: absolute;\n" +
                        "\t\t\t\ttop: 55%;\n" +
                        "\t\t\t\tleft: 24%;\n" +
                        "\t\t\t\ttransform: translate(-50%, -50%);\n" +
                        "\t\t\t\tcolor: black;\n" +
                        "\t\t\t\t\n" +
                        "\t\t\t\ttext-align: center;\n" +
                        "\t\t\t   \n" +
                        "\t\t\t\tpadding: 10px;\n" +
                        "\t\t\t}\n" +
                        "\t\t</style>\n" +
                        "\t</head>\n" +
                        "\t<body>\n" +
                        "\t\t<div class=\"container\">\n" +
                        "\t\t\t<img class=\"image\" src=\"img_temp.jpeg\" alt=\"Your Image\">\n" +
                        "\t\t\t<div class=\"text\">\n" +
                        "\t\t\t\t<b>" + temperature + "</b>\n" +
                        "\t\t\t</div>\n" +
                        "\t\t</div>\n" +
                        "\t</body>\n" +
                        "\t</html>\n";
    }
}
