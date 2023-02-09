
class ciftEleman {

    int icerik;
    ciftEleman ileri;
    ciftEleman geri;

    ciftEleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
        geri = null;
    }
}

public class ciftListe {

    ciftEleman bas;

    public ciftListe() {
        bas = null;
    }

    void basaEkle(ciftEleman yeni) {
        if (bas == null) {
            bas = yeni;

        } else {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        }
    }

    void sonaEKle(ciftEleman yeni) {
        if (bas == null) {
            bas = yeni; //liste boş ise
        } else {
            ciftEleman tmp = bas;
            while (tmp.ileri != null) {
                tmp = tmp.ileri;
            }
            tmp.ileri = yeni;
            yeni.geri = tmp;
        }
    }

    void bastanSil() {
        if (bas != null) {
            if (bas.ileri == null) {
                bas = null;
            } else {
                bas = bas.ileri; //dikkat et aklında tut
                bas.geri = null;
            }
        }
    }

    String Lİstele() {
        String S = "";
        ciftEleman tmp = bas;
        while (tmp != null) {
            S = S + tmp.icerik + "<->";
            tmp = tmp.ileri;
        }
        return S;
    }

    String sondanListele() {
        if (bas == null) {
            return "";
        } else if (bas.ileri == null) {
            return bas.icerik + "<->";
        } else {
            ciftEleman tmp = bas;
            String S = "";
            while (tmp.ileri != null) {
                tmp = tmp.ileri;
            }
            while (tmp != null) {
                S = S + tmp.icerik + "<->";
                tmp = tmp.geri;
            }
            return S;

        }

    }

    void siraliEkle(ciftEleman yeni) {
        if (bas == null) { //liste boş ise
            bas = yeni;
        } else if (bas.icerik >= yeni.icerik) {
            yeni.ileri = bas;
            bas.geri = yeni;
            bas = yeni;
        } else {
            ciftEleman tmp = bas;
            while (tmp.ileri != null && tmp.ileri.icerik < yeni.icerik) {
                tmp = tmp.ileri;
                yeni.ileri = tmp.ileri;
            }
            if (tmp.ileri != null) {
                yeni.ileri.geri = yeni;
            }
            tmp.ileri=yeni;
            yeni.geri=tmp;                                                                              
        }
    }
}
