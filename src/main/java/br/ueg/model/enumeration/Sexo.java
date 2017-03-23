package br.ueg.model.enumeration;

/**
 * Created by joel on 22/03/17.
 */
public enum Sexo {
    MASCULINO("M"),
    FEMININO("F"),
    OUTROS("O");

    private Sexo(String value) {
        this.VALUE = value;
    }

    private final String VALUE;

    @Override
    public String toString() {
        return VALUE;
    }
}
