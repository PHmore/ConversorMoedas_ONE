package br.com.conversor.model;

import com.google.gson.annotations.SerializedName;

public class Conversao {

    private Double taxaConv;
    private String codBase;
    private String codAlvo;

    public Conversao(Double taxaConv, String codBase, String codAlvo) {
        this.taxaConv = taxaConv;
        this.codBase = codBase;
        this.codAlvo = codAlvo;
    }

    public Conversao(ConversaoER conversaoER)
    {
        this.taxaConv = conversaoER.conversion_rate();
        this.codAlvo = conversaoER.target_code();
        this.codBase = conversaoER.base_code();
    }

    public Double getTaxaConv() {
        return taxaConv;
    }

    public void setTaxaConv(Double taxaConv) {
        this.taxaConv = taxaConv;
    }

    public String getCodBase() {
        return codBase;
    }

    public void setCodBase(String codBase) {
        this.codBase = codBase;
    }

    public String getCodAlvo() {
        return codAlvo;
    }

    public void setCodAlvo(String codAlvo) {
        this.codAlvo = codAlvo;
    }

    @Override
    public String toString() {
        return "Conversao{" +
                "taxaConv=" + taxaConv +
                ", codBase='" + codBase + '\'' +
                ", codAlvo='" + codAlvo + '\'' +
                '}';
    }
}
