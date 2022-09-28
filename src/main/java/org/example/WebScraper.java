package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;

import java.io.IOException;
import java.util.List;

public class WebScraper {
    WebClient webClient = new WebClient();
    HtmlPage page;

    public WebScraper() throws IOException {
        String url = "https://www.breizhchrono.com";
        page = getWebPage(url);
    }

    private HtmlPage getWebPage(String url) throws IOException {
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);
        return webClient.getPage(url);
    }

    /**
     * Méthode en charge de trouver un lien dans une page html à l'aide d'un texte
     *
     * @param search représente le texte à rechercher
     * @param page   représente le page dans laquelle la recherche est effectuée
     */
    public HtmlAnchor findAnchorByText(String search, HtmlPage page) {
        List<HtmlAnchor> anchors = page.getAnchors();
        String href = null;

        for (HtmlAnchor temp : anchors) {
            href = temp.getHrefAttribute();

            if (temp.getTextContent().contains(search))
                break;
        }
        HtmlAnchor foundAnchor = page.getAnchorByHref(href);
        return foundAnchor;
    }


    /**
     * Méthode en charge d'extraire les informations d'un coureur dans un tableau
     *
     * @param table   représente le tableau
     * @param coureur représente le coureur
     */
    public void extraireInformationCoureur(HtmlTable table, Coureur coureur) {
        coureur.setClassement(Integer.parseInt(table.getCellAt(1, 0).asNormalizedText()));
        coureur.setNom(table.getCellAt(1, 1).asNormalizedText());
        coureur.setCategorie(table.getCellAt(1, 2).asNormalizedText());
        coureur.setCategorie(table.getCellAt(1, 2).asNormalizedText());
        coureur.setSexe(table.getCellAt(1, 3).asNormalizedText());
        if (!"".equals(table.getCellAt(1, 4).asNormalizedText())) {
            coureur.setClub(table.getCellAt(1, 4).asNormalizedText());
        }
        coureur.setTemps(table.getCellAt(1, 5).asNormalizedText());
    }
}

