//zamiana Celcjuszy na Kelviny
function fromCelcjuszToKelvin(wartosc) {
    return wartosc + 273.15;
}
//zamiana Kelviny na Celcjusze
function fromKelvinToCelcjusz(wartosc) {
    return wartosc - 273.15;
}
//zamiana Celcjusze na Farenheity
function fromCelcjuszToFarenheit(wartosc) {
    return wartosc * 1.8 + 32;
}
//zamiana Farenheity na Celcjusze
function fromFarenheitToCelcjusz(wartosc) {
    return (wartosc - 32) * 5 / 9;
}
//zamiana Kelviny na Farenheity
function fromKelvinToFarenheit(wartosc) {
    return fromCelcjuszToFarenheit(fromKelvinToCelcjusz(wartosc));
}
//zamiana Farenheity na Kelviny
function fromFarenheitToKelvin(wartosc) {
    return fromCelcjuszToKelvin(fromFarenheitToCelcjusz(wartosc));
}
//dodanie porównania temperatur do zawartości panelu
function zapiszTemperature(wartosc,jednostkaOd,jednostkaDo) {
    if(jednostkaOd.toString()==="Celcjusz"){
        if(jednostkaDo.toString()==="Farenheit"){
            return "&degC = "+wartosc+"&degF";
        }
        else if(jednostkaDo.toString()==="Kelvin"){
            return "&degC = "+wartosc+" K";
        }
    }
    if(jednostkaOd.toString()==="Kelvin"){
        if(jednostkaDo.toString()==="Farenheit"){
            return " K = "+wartosc+"&degF";
        }
        else if(jednostkaDo.toString()==="Celcjusz"){
            return " K = "+wartosc+"&degC";
        }
    }
    if(jednostkaOd.toString()==="Farenheit"){
        if(jednostkaDo.toString()==="Kelvin"){
            return "&degF = "+wartosc+" K";
        }
        else if(jednostkaDo.toString()==="Celcjusz"){
            return "&degF = "+wartosc+"&degC";
        }
    }
}
//dodanie informacji o błędnych obliczeniach dla Kelvinów
function errorKelvin(jednostkaOd,jednostkaDo) {
    if(jednostkaOd.toString()==="Celcjusz" || jednostkaOd.toString()==="Farenheit" && jednostkaDo.toString()==="Kelvin"){
        return " wartość w Kelvinach będzie mniejsza od 0.";
    }
    else if(jednostkaOd.toString()==="Kelvin"){
        return "Nie można obliczyć temperatury w Kelvinach dla wartości mniejszej od 0.";
    }
}
//sprawdzanie jednostek
function sprawdzJednostki(wartosc, jednostki) {
    if (jednostki.length === 2) {
        var jednostkaOd, jednostkaDo;
        //wartość jednostki
        jednostkaOd = jednostki[0].value.toString();
        jednostkaDo = jednostki[1].value.toString();
        //informacje dla formularzy
        var komunikatOd = document.getElementById("komunikatOd");
        var komunikatDo = document.getElementById("komunikatDo");
        //elementy z wartościami jednostek
        var inputOd = document.getElementById("jednostka_od");
        var inputDo = document.getElementById("jednostka_do");
        var wartoscStyle = document.getElementById("wartosc");
        var wynik = document.getElementById("wynik");
        var panelWynikowy = document.getElementById("panelWyniku");
        var optionList = document.getElementsByTagName("option");
        //ustawianie styli na stworzone w CSS
        inputOd.style.border="";
        inputDo.style.border="";
        wartoscStyle.style.border="";
        komunikatDo.style.display = "";
        komunikatOd.style.display = "";
        panelWynikowy.style.display = "";
        //tablica wartości elementu DATALIST
        const tablicaOpcji = [];
        for (var o = 0; o < optionList.length; o++) {
            tablicaOpcji[o] = optionList[o].value;
        }
        //sprawdzanie warunków wartości w inputach
        if (wartosc) {
            if (tablicaOpcji.indexOf(jednostkaOd) !== -1) {
                if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                    if (jednostkaOd === jednostkaDo) {
                        panelWynikowy.style.display = "block";
                        inputOd.style.border="4px solid red";
                        inputDo.style.border="4px solid red";
                        wynik.innerHTML = "Jednostka wejściowa jest taka sama jak wyjściowa";
                    } else {
                        //przejsćie do przeliczania wartości
                        przeliczTemperature(wartosc, jednostkaOd, jednostkaDo);
                    }
                } else {
                    komunikatDo.style.display = "inline";
                    inputDo.style.border="4px solid red";
                    if (jednostkaDo === "") {
                        komunikatDo.innerHTML = "Brak jednostki wyjściowej";
                    } else {
                        komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                    }
                }
            } else {
                if (jednostkaOd === "") {
                    inputOd.style.border="4px solid red";
                    if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                        komunikatOd.style.display = "inline";
                        komunikatOd.innerHTML = "Brak jednostki wejściowej";  
                    } else {
                        inputDo.style.border="4px solid red";
                        if (jednostkaDo === "") {
                            panelWynikowy.style.display = "block";
                            wynik.innerHTML = "Brak jednostki wejściowej i wyjściowej";
                        } else {
                            komunikatDo.style.display = "inline";
                            komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                            komunikatOd.style.display = "inline";
                            komunikatOd.innerHTML = "Brak jednostki wejściowej"; 
                        }
                    }
                } else {
                    inputOd.style.border="4px solid red";
                    if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                        komunikatOd.style.display = "inline";
                        komunikatOd.innerHTML = "Nieprawidłowa jednostka: " + jednostkaOd;
                    } else {
                        inputDo.style.border="4px solid red";
                        if (jednostkaDo === "") {
                            komunikatOd.style.display = "inline";
                            komunikatOd.innerHTML = "Nieprawidłowa jednostka: " + jednostkaOd;
                            komunikatDo.style.display = "inline";
                            komunikatDo.innerHTML = "Brak jednostki wejściowej"; 
                        } else {
                            if(jednostkaOd===jednostkaDo){
                                panelWynikowy.style.display = "block";
                                wynik.innerHTML = "Nieprawidłowa jednostka wejściowa i wyjściowa: "+ jednostkaOd;
                            }
                            else{
                                komunikatDo.style.display = "inline";
                                komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                                komunikatOd.style.display = "inline";
                                komunikatOd.innerHTML = "Nieprawidłowa jednostka: " + jednostkaOd;
                            }
                        }
                    }
                }

            }
        } else {
            wartoscStyle.style.border="4px solid red";
            if (tablicaOpcji.indexOf(jednostkaOd) !== -1) {
                komunikatOd.style.display = "inline";
                komunikatOd.innerHTML = "Brak wartości do przeliczenia";
                if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                    if (jednostkaOd === jednostkaDo) {
                        panelWynikowy.style.display = "block";
                        wynik.innerHTML = "Jednostka wejściowa jest taka sama jak wyjściowa";
                        inputDo.style.border="4px solid red";
                        inputOd.style.border="4px solid red";
                    } else {
                        wartoscStyle.style.border="4px solid red";
                    }
                } else {
                    komunikatDo.style.display = "inline";
                    inputDo.style.border="4px solid red";
                    if (jednostkaDo === "") {
                        komunikatDo.innerHTML = "Brak jednostki wyjściowej";
                    } else {
                        komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                    }
                }
            } else {
                if (jednostkaOd === "") {
                    komunikatOd.style.display = "inline";
                    inputOd.style.border="4px solid red";
                    if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                        komunikatOd.innerHTML = "Brak wartości do przeliczenia i jednostki wejściowej";
                    } else {
                        inputOd.style.border="4px solid red";
                        inputDo.style.border="4px solid red";
                        if (jednostkaDo === "") {
                            komunikatOd.innerHTML = "Brak wartości do przeliczenia";
                            panelWynikowy.style.display = "block";
                            wynik.innerHTML = "Brak jednostki wejściowej i wyjściowej";
                            
                        } else {
                            komunikatDo.style.display = "inline";
                            komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                            komunikatOd.innerHTML = "Brak wartości do przeliczenia i jednostki wejściowej";
                        }
                    }
                } else {
                    komunikatOd.style.display = "inline";
                    inputOd.style.border="4px solid red";
                    if (tablicaOpcji.indexOf(jednostkaDo) !== -1) {
                        komunikatOd.innerHTML = "Brak wartości do przeliczenia i nieprawidłowa jednostka: " + jednostkaOd; 
                    } else {
                        komunikatDo.style.display = "inline";
                        inputDo.style.border="4px solid red";
                        if (jednostkaDo === "") {
                            komunikatOd.innerHTML = "Brak wartości do przeliczenia i nieprawidłowa jednostka: " + jednostkaOd;
                            komunikatDo.innerHTML = "Brak jednostki wejściowej"; 
                        } else {
                            if(jednostkaOd===jednostkaDo){
                                komunikatOd.innerHTML = "Brak wartości do przeliczenia";
                                panelWynikowy.style.display = "block";
                                wynik.innerHTML = "Nieprawidłowa jednostka wejściowa i wyjściowa: "+ jednostkaOd;
                            }
                            else{
                                komunikatDo.innerHTML = "Nieprawidłowa jednostka: " + jednostkaDo;
                                komunikatOd.innerHTML = "Brak wartości do przeliczenia i nieprawidłowa jednostka: " + jednostkaOd; 
                           }
                        }
                    }
                }

            }
        }
    }
};
//funkcja do przeliczania temperatur
function przeliczTemperature(wartosc, jednostkaOd, jednostkaDo) {
    var jednostkaWejsciowa = jednostkaOd.toString();
    var jednostkaWyjsciowa = jednostkaDo.toString();
    var wartoscTemperatury = parseFloat(wartosc);
    var wartoscStyle = document.getElementById("wartosc");
    var wynik = document.getElementById("wynik");
    var panelWynikowy = document.getElementById("panelWyniku");
    panelWynikowy.style.display="block";
    //dla Celcjuszy
    if (jednostkaWejsciowa.includes("Celcjusz")) {
        if (jednostkaWyjsciowa.includes("Kelvin")) {
            wartoscTemperatury = Math.round(fromCelcjuszToKelvin(wartoscTemperatury)*100)/100;
            //gdy wartość w Kelvinach jest mniejsza od 0
            if (wartoscTemperatury < 0) {
                //zawartośc z wartością funkcji o błędzie
                wynik.innerHTML="Dla temperatury "+wartosc+"&degC"+errorKelvin(jednostkaWejsciowa,jednostkaWyjsciowa);
                wartoscStyle.style.border="4px solid red";
                wynik.style.left="10%";
                wynik.style.transform="translate(-10%,-50%)";
            } else {
                wynik.innerHTML="Zamiana Celcjuszy na Kelviny: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
            }
        } else if (jednostkaWyjsciowa.includes("Farenheit")) {
            wartoscTemperatury = Math.round(fromCelcjuszToFarenheit(wartoscTemperatury)*100)/100;
            wynik.innerHTML="Zamiana Celcjuszy na Farenheity: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
            
        }
    }
    //dla Kelvinów
    else if (jednostkaWejsciowa.includes("Kelvin")) {
        //gdy wartość w Kelvinach jest mniejsza od 0
        if (wartoscTemperatury < 0) {
            wartoscStyle.style.border="4px solid red";
            wynik.innerHTML=errorKelvin(jednostkaWejsciowa,jednostkaWyjsciowa);
            wynik.style.left="10%";
            wynik.style.transform="translate(-10%,-50%)";
        } else {
            if (jednostkaWyjsciowa.includes("Celcjusz")) {
                wartoscTemperatury = Math.round(fromKelvinToCelcjusz(wartoscTemperatury)*100)/100;
                wynik.innerHTML="Zamiana Kelviny na Celcjusze: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
            } else if (jednostkaWyjsciowa.includes("Farenheit")) {
                wartoscTemperatury = Math.round(fromKelvinToFarenheit(wartoscTemperatury)*100)/100;
                wynik.innerHTML="Zamiana Kelviny na Farenheity: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
            }
        }
    } 
    //dla Farenheitów
    else if (jednostkaWejsciowa.includes("Farenheit")) {
        if (jednostkaWyjsciowa.includes("Celcjusz")) {
            wartoscTemperatury = Math.round(fromFarenheitToCelcjusz(wartoscTemperatury)*100)/100;
            wynik.innerHTML="Zamiana Farenheity na Celcjusze: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
        } else if (jednostkaWyjsciowa.includes("Kelvin")) {
            wartoscTemperatury = Math.round(fromFarenheitToKelvin(wartoscTemperatury)*100)/100;
            //gdy wartość w Kelvinach jest mniejsza od 0
            if (wartoscTemperatury < 0) {
                wartoscStyle.style.border="4px solid red";
                wynik.innerHTML="Dla temperatury "+wartosc+"&degF"+errorKelvin(jednostkaWejsciowa,jednostkaWyjsciowa);
                wynik.style.left="10%";
                wynik.style.transform="translate(-10%,-50%)";
            } else {
                wynik.innerHTML="Zamiana Farenheity na Kelviny: "+wartosc+zapiszTemperature(wartoscTemperatury,jednostkaWejsciowa,jednostkaWyjsciowa);
            }
        }
    }

}
//wczytanie okna
window.onload = function () {
    var oblicz = document.getElementById("oblicz");
    var wartosc = document.getElementById("wartosc");
    const jednostki = document.getElementsByClassName("lista");
    //zdarzenie kliknięcie na przycisk
    oblicz.onclick = function () {
        sprawdzJednostki(wartosc.value, jednostki);
    };
};
