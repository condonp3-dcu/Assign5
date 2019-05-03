package sda.oscail.edu.proj05_2019_p_condontemp;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * * citation
 * Class contains code adapted from :
 * https://www.youtube.com/watch?v=u1zb4dHthss
 * https://www.androidauthority.com/retrofit-android-tutorial-906928/
 * https://github.com/square/retrofit
 * https://www.javatpoint.com/android-json-parsing-tutorial
 */

import java.util.ArrayList;
import java.util.List;

/**
 * get exchange rates and put in CurrencyList() Rated below are the ones
 * available from fixer.io
 */
public class FixerRates {

    private String base;
    private String date;
    private FetchRates rates;

    public List<Currencies> getCurrencyList(){
        List<Currencies> currenciesList = new ArrayList<>();
        currenciesList.add(new Currencies("AED", rates.getAED()));
        currenciesList.add(new Currencies("AFN", rates.getAFN()));
        currenciesList.add(new Currencies("ALL", rates.getALL()));
        currenciesList.add(new Currencies("AMD", rates.getAMD()));
        currenciesList.add(new Currencies("ANG", rates.getANG()));

        currenciesList.add(new Currencies("AOA", rates.getAOA()));
        currenciesList.add(new Currencies("ARS", rates.getARS()));
        currenciesList.add(new Currencies("AUD", rates.getAUD()));
        currenciesList.add(new Currencies("AWG", rates.getAWG()));
        currenciesList.add(new Currencies("AZN", rates.getAZN()));

        currenciesList.add(new Currencies("BAM", rates.getBAM()));
        currenciesList.add(new Currencies("BBD", rates.getBBD()));
        currenciesList.add(new Currencies("BDT", rates.getBDT()));
        currenciesList.add(new Currencies("BGN", rates.getBGN()));
        currenciesList.add(new Currencies("BHD", rates.getBHD()));

        currenciesList.add(new Currencies("BIF", rates.getBIF()));
        currenciesList.add(new Currencies("BMD", rates.getBMD()));
        currenciesList.add(new Currencies("BND", rates.getBND()));
        currenciesList.add(new Currencies("BOB", rates.getBOB()));
        currenciesList.add(new Currencies("BRL", rates.getBRL()));

        currenciesList.add(new Currencies("BSD", rates.getBSD()));
        currenciesList.add(new Currencies("BTC", rates.getBTC()));
        currenciesList.add(new Currencies("BTN", rates.getBTN()));
        currenciesList.add(new Currencies("BWP", rates.getBWP()));
        currenciesList.add(new Currencies("BYN", rates.getBYN()));

        currenciesList.add(new Currencies("BYR", rates.getBYR()));
        currenciesList.add(new Currencies("BZD", rates.getBZD()));
        currenciesList.add(new Currencies("CAD", rates.getCAD()));
        currenciesList.add(new Currencies("CDF", rates.getCDF()));
        currenciesList.add(new Currencies("CHF", rates.getCHF()));

        currenciesList.add(new Currencies("CLF", rates.getCLF()));
        currenciesList.add(new Currencies("CLP", rates.getCLP()));
        currenciesList.add(new Currencies("CNY", rates.getCNY()));
        currenciesList.add(new Currencies("COP", rates.getCOP()));

        currenciesList.add(new Currencies("CRC", rates.getCRC()));
        currenciesList.add(new Currencies("CUC", rates.getCUC()));
        currenciesList.add(new Currencies("CUP", rates.getCUP()));
        currenciesList.add(new Currencies("CVE", rates.getCVE()));
        currenciesList.add(new Currencies("CZK", rates.getCZK()));

        currenciesList.add(new Currencies("DJF", rates.getDJF()));
        currenciesList.add(new Currencies("DKK", rates.getDKK()));
        currenciesList.add(new Currencies("DOP", rates.getDOP()));
        currenciesList.add(new Currencies("DZD", rates.getDZD()));
        currenciesList.add(new Currencies("EGP", rates.getEGP()));

        currenciesList.add(new Currencies("ERN", rates.getERN()));
        currenciesList.add(new Currencies("ETB", rates.getETB()));
        currenciesList.add(new Currencies("EUR", rates.getEUR()));
        currenciesList.add(new Currencies("FJD", rates.getFJD()));
        currenciesList.add(new Currencies("FKP", rates.getFKP()));

        currenciesList.add(new Currencies("GBP", rates.getGBP()));
        currenciesList.add(new Currencies("GEL", rates.getGEL()));
        currenciesList.add(new Currencies("GGP", rates.getGGP()));
        currenciesList.add(new Currencies("GHS", rates.getGHS()));
        currenciesList.add(new Currencies("GIP", rates.getGIP()));

        currenciesList.add(new Currencies("GMD", rates.getGMD()));
        currenciesList.add(new Currencies("GNF", rates.getGNF()));
        currenciesList.add(new Currencies("GTQ", rates.getGTQ()));
        currenciesList.add(new Currencies("GYD", rates.getGYD()));
        currenciesList.add(new Currencies("HKD", rates.getHKD()));

        currenciesList.add(new Currencies("HNL", rates.getHNL()));
        currenciesList.add(new Currencies("HRK", rates.getHRK()));
        currenciesList.add(new Currencies("HTG", rates.getHTG()));
        currenciesList.add(new Currencies("HUF", rates.getHUF()));

        currenciesList.add(new Currencies("IDR", rates.getIDR()));
        currenciesList.add(new Currencies("ILS", rates.getILS()));
        currenciesList.add(new Currencies("IMP", rates.getIMP()));
        currenciesList.add(new Currencies("INR", rates.getINR()));

        currenciesList.add(new Currencies("IQD", rates.getIQD()));

        currenciesList.add(new Currencies("IRR", rates.getIRR()));
        currenciesList.add(new Currencies("ISK", rates.getISK()));
        currenciesList.add(new Currencies("JEP", rates.getJEP()));
        currenciesList.add(new Currencies("JMD", rates.getJMD()));
        currenciesList.add(new Currencies("JOD", rates.getJOD()));

        currenciesList.add(new Currencies("JPY", rates.getJPY()));
        currenciesList.add(new Currencies("KES", rates.getKES()));
        currenciesList.add(new Currencies("KGS", rates.getKGS()));
        currenciesList.add(new Currencies("KHR", rates.getKHR()));

        currenciesList.add(new Currencies("KMF", rates.getKMF()));
        currenciesList.add(new Currencies("KPW", rates.getKPW()));
        currenciesList.add(new Currencies("KRW", rates.getKRW()));
        currenciesList.add(new Currencies("KWD", rates.getKWD()));

        currenciesList.add(new Currencies("KYD", rates.getKYD()));
        currenciesList.add(new Currencies("KZT", rates.getKZT()));
        currenciesList.add(new Currencies("LAK", rates.getLAK()));
        currenciesList.add(new Currencies("LBP", rates.getLBP()));

        currenciesList.add(new Currencies("LKR", rates.getLKR()));
        currenciesList.add(new Currencies("LRD", rates.getLRD()));
        currenciesList.add(new Currencies("LSL", rates.getLSL()));
        currenciesList.add(new Currencies("LTL", rates.getLTL()));

        currenciesList.add(new Currencies("LVL", rates.getLVL()));
        currenciesList.add(new Currencies("LYD", rates.getLYD()));
        currenciesList.add(new Currencies("MAD", rates.getMAD()));
        currenciesList.add(new Currencies("MDL", rates.getMDL()));

        currenciesList.add(new Currencies("MGA", rates.getMGA()));
        currenciesList.add(new Currencies("MKD", rates.getMKD()));
        currenciesList.add(new Currencies("MMK", rates.getMMK()));
        currenciesList.add(new Currencies("MNT", rates.getMNT()));

        currenciesList.add(new Currencies("MOP", rates.getMOP()));
        currenciesList.add(new Currencies("MRO", rates.getMRO()));
        currenciesList.add(new Currencies("MUR", rates.getMUR()));
        currenciesList.add(new Currencies("MVR", rates.getMVR()));

        currenciesList.add(new Currencies("MWK", rates.getMWK()));

        currenciesList.add(new Currencies("MXN", rates.getMXN()));
        currenciesList.add(new Currencies("MYR", rates.getMYR()));
        currenciesList.add(new Currencies("MZN", rates.getMZN()));
        currenciesList.add(new Currencies("NAD", rates.getNAD()));

        currenciesList.add(new Currencies("NGN", rates.getNGN()));
        currenciesList.add(new Currencies("NIO", rates.getNIO()));
        currenciesList.add(new Currencies("IOK", rates.getNOK()));
        currenciesList.add(new Currencies("NPR", rates.getNPR()));

        currenciesList.add(new Currencies("NZD", rates.getNZD()));
        currenciesList.add(new Currencies("OMR", rates.getOMR()));
        currenciesList.add(new Currencies("PAB", rates.getPAB()));
        currenciesList.add(new Currencies("PEN", rates.getPEN()));

        currenciesList.add(new Currencies("PGK", rates.getPGK()));
        currenciesList.add(new Currencies("PHP", rates.getPHP()));
        currenciesList.add(new Currencies("PKR", rates.getPKR()));
        currenciesList.add(new Currencies("PLN", rates.getPLN()));

        currenciesList.add(new Currencies("PYG", rates.getPYG()));
        currenciesList.add(new Currencies("QAR", rates.getQAR()));
        currenciesList.add(new Currencies("RON", rates.getRON()));
        currenciesList.add(new Currencies("RSD", rates.getRSD()));

        currenciesList.add(new Currencies("RUB", rates.getRUB()));

        currenciesList.add(new Currencies("RWF", rates.getRWF()));
        currenciesList.add(new Currencies("SAR", rates.getSAR()));
        currenciesList.add(new Currencies("SBD", rates.getSBD()));
        currenciesList.add(new Currencies("SCR", rates.getSCR()));

        currenciesList.add(new Currencies("SDG", rates.getSDG()));
        currenciesList.add(new Currencies("SEK", rates.getSEK()));
        currenciesList.add(new Currencies("SGD", rates.getSGD()));
        currenciesList.add(new Currencies("SHP", rates.getSHP()));

        currenciesList.add(new Currencies("SLL", rates.getSLL()));
        currenciesList.add(new Currencies("SOS", rates.getSOS()));
        currenciesList.add(new Currencies("SRD", rates.getSRD()));
        currenciesList.add(new Currencies("STD", rates.getSTD()));

        currenciesList.add(new Currencies("SVC", rates.getSVC()));
        currenciesList.add(new Currencies("SYP", rates.getSYP()));
        currenciesList.add(new Currencies("SZL", rates.getSZL()));
        currenciesList.add(new Currencies("THB", rates.getTHB()));

        currenciesList.add(new Currencies("TJS", rates.getTJS()));
        currenciesList.add(new Currencies("TMT", rates.getTMT()));
        currenciesList.add(new Currencies("TND", rates.getTND()));
        currenciesList.add(new Currencies("TOP", rates.getTOP()));

        currenciesList.add(new Currencies("TRY", rates.getTRY()));
        currenciesList.add(new Currencies("TTD", rates.getTTD()));
        currenciesList.add(new Currencies("TWD", rates.getTWD()));
        currenciesList.add(new Currencies("TZS", rates.getTZS()));

        currenciesList.add(new Currencies("UAH", rates.getUAH()));
        currenciesList.add(new Currencies("UGX", rates.getUGX()));
        currenciesList.add(new Currencies("USD", rates.getUSD()));
        currenciesList.add(new Currencies("UYU", rates.getUYU()));

        currenciesList.add(new Currencies("UZS", rates.getUZS()));
        currenciesList.add(new Currencies("VEF", rates.getVEF()));
        currenciesList.add(new Currencies("VND", rates.getVND()));
        currenciesList.add(new Currencies("VUV", rates.getVUV()));

        currenciesList.add(new Currencies("WST", rates.getWST()));
        currenciesList.add(new Currencies("XAF", rates.getXAF()));
        currenciesList.add(new Currencies("XAG", rates.getXAG()));
        currenciesList.add(new Currencies("XAU", rates.getXAU()));

        currenciesList.add(new Currencies("XCD", rates.getXCD()));
        currenciesList.add(new Currencies("XDR", rates.getXDR()));
        currenciesList.add(new Currencies("XOF", rates.getXOF()));
        currenciesList.add(new Currencies("XPF", rates.getXPF()));

        currenciesList.add(new Currencies("YER", rates.getYER()));
        currenciesList.add(new Currencies("ZAR", rates.getZAR()));
        currenciesList.add(new Currencies("ZMK", rates.getZMK()));
        currenciesList.add(new Currencies("ZMW", rates.getZMW()));

        currenciesList.add(new Currencies("ZWL", rates.getZWL()));

        return currenciesList;
    }


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static class FetchRates {
        private double AED;
        private double AFN ;
        private double ALL;
        private double AMD;
        private double ANG ;
        private double AOA;
        private double ARS;
        private double AUD;
        private double AWG;
        private double AZN;
        private double BAM;
        private double BBD;
        private double BDT;
        private double BGN;
        private double BHD;
        private double BIF;
        private double BMD;
        private double BND;
        private double BOB;
        private double BRL;
        private double BSD;
        private double BTC;
        private double BTN;
        private double BWP;
        private double BYN;
        private double BYR;
        private double BZD;
        private double CAD;
        private double CDF;
        private double CHF;
        private double CLF;
        private double CLP;
        private double CNY;
        private double COP;
        private double CRC;
        private double CUC;
        private double CUP;
        private double CVE;
        private double CZK;
        private double DJF;
        private double DKK;
        private double DOP;
        private double DZD;
        private double EGP;
        private double ERN;
        private double ETB;
        private double EUR;
        private double FJD;
        private double FKP;
        private double GBP;
        private double GEL;
        private double GGP;
        private double GHS;
        private double GIP;
        private double GMD;
        private double GNF;
        private double GTQ;
        private double GYD;
        private double HKD;
        private double HNL;
        private double HRK;
        private double HTG;
        private double HUF;
        private double IDR;
        private double ILS;
        private double IMP;
        private double INR;
        private double IQD;
        private double IRR;
        private double ISK;
        private double JEP;
        private double JMD;
        private double JOD;
        private double JPY;
        private double KES;
        private double KGS;
        private double KHR;
        private double KMF;
        private double KPW;
        private double KRW;
        private double KWD;
        private double KYD;
        private double KZT;
        private double LAK;
        private double LBP;
        private double LKR;
        private double LRD;
        private double LSL;
        private double LTL;
        private double LVL;
        private double LYD;
        private double MAD;
        private double MDL;
        private double MGA;
        private double MKD;
        private double MMK;
        private double MNT;
        private double MOP;
        private double MRO;
        private double MUR;
        private double MVR;
        private double MWK;
        private double MXN;
        private double MYR;
        private double MZN;
        private double NAD;
        private double NGN;
        private double NIO;
        private double NOK;
        private double NPR;
        private double NZD;
        private double OMR;
        private double PAB;
        private double PEN;
        private double PGK;
        private double PHP;
        private double PKR;
        private double PLN;
        private double PYG;
        private double QAR;
        private double RON;
        private double RSD;
        private double RUB;
        private double RWF;
        private double SAR;
        private double SBD;
        private double SCR;
        private double SDG;
        private double SEK;
        private double SGD;
        private double SHP;
        private double SLL;
        private double SOS;
        private double SRD;
        private double STD;
        private double SVC;
        private double SYP;
        private double SZL;
        private double THB;
        private double TJS;
        private double TMT;
        private double TND;
        private double TOP;
        private double TRY;
        private double TTD;
        private double TWD;
        private double TZS;
        private double UAH;
        private double UGX;
        private double USD;
        private double UYU;
        private double UZS;
        private double VEF;
        private double VND;
        private double VUV;
        private double WST;
        private double XAF;
        private double XAG;
        private double XAU;
        private double XCD;
        private double XDR;
        private double XOF;
        private double XPF;
        private double YER;
        private double ZAR;
        private double ZMK;
        private double ZMW;
        private double ZWL;

        public double getAED() {
            return AED;
        }

        public double getAFN() {
            return AFN;
        }

        public double getALL() {
            return ALL;
        }

        public double getAMD() {
            return AMD;
        }

        public double getANG() {
            return ANG;
        }

        public double getAOA() {
            return AOA;
        }

        public double getARS() {
            return ARS;
        }

        public double getAUD() {
            return AUD;
        }

        public double getAWG() {
            return AWG;
        }

        public double getAZN() {
            return AZN;
        }

        public double getBAM() {
            return BAM;
        }

        public double getBBD() {
            return BBD;
        }

        public double getBDT() {
            return BDT;
        }

        public double getBGN() {
            return BGN;
        }

        public double getBHD() {
            return BHD;
        }

        public double getBIF() {
            return BIF;
        }

        public double getBMD() {
            return BMD;
        }

        public double getBND() {
            return BND;
        }

        public double getBOB() {
            return BOB;
        }

        public double getBRL() {
            return BRL;
        }

        public double getBSD() {
            return BSD;
        }

        public double getBTC() {
            return BTC;
        }

        public double getBTN() {
            return BTN;
        }

        public double getBWP() {
            return BWP;
        }

        public double getBYN() {
            return BYN;
        }

        public double getBYR() {
            return BYR;
        }

        public double getBZD() {
            return BZD;
        }

        public double getCAD() {
            return CAD;
        }

        public double getCDF() {
            return CDF;
        }

        public double getCHF() {
            return CHF;
        }

        public double getCLF() {
            return CLF;
        }

        public double getCLP() {
            return CLP;
        }

        public double getCNY() {
            return CNY;
        }

        public double getCOP() {
            return COP;
        }

        public double getCRC() {
            return CRC;
        }

        public double getCUC() {
            return CUC;
        }

        public double getCUP() {
            return CUP;
        }

        public double getCVE() {
            return CVE;
        }

        public double getCZK() {
            return CZK;
        }

        public double getDJF() {
            return DJF;
        }

        public double getDKK() {
            return DKK;
        }

        public double getDOP() {
            return DOP;
        }

        public double getDZD() {
            return DZD;
        }

        public double getEGP() {
            return EGP;
        }

        public double getERN() {
            return ERN;
        }

        public double getETB() {
            return ETB;
        }

        public double getEUR() {
            return EUR;
        }

        public double getFJD() {
            return FJD;
        }

        public double getFKP() {
            return FKP;
        }

        public double getGBP() {
            return GBP;
        }

        public double getGEL() {
            return GEL;
        }

        public double getGGP() {
            return GGP;
        }

        public double getGHS() {
            return GHS;
        }

        public double getGIP() {
            return GIP;
        }

        public double getGMD() {
            return GMD;
        }

        public double getGNF() {
            return GNF;
        }

        public double getGTQ() {
            return GTQ;
        }

        public double getGYD() {
            return GYD;
        }

        public double getHKD() {
            return HKD;
        }

        public double getHNL() {
            return HNL;
        }

        public double getHRK() {
            return HRK;
        }

        public double getHTG() {
            return HTG;
        }

        public double getHUF() {
            return HUF;
        }

        public double getIDR() {
            return IDR;
        }

        public double getILS() {
            return ILS;
        }

        public double getIMP() {
            return IMP;
        }

        public double getINR() {
            return INR;
        }

        public double getIQD() {
            return IQD;
        }

        public double getIRR() {
            return IRR;
        }

        public double getISK() {
            return ISK;
        }

        public double getJEP() {
            return JEP;
        }

        public double getJMD() {
            return JMD;
        }

        public double getJOD() {
            return JOD;
        }

        public double getJPY() {
            return JPY;
        }

        public double getKES() {
            return KES;
        }

        public double getKGS() {
            return KGS;
        }

        public double getKHR() {
            return KHR;
        }

        public double getKMF() {
            return KMF;
        }

        public double getKPW() {
            return KPW;
        }

        public double getKRW() {
            return KRW;
        }

        public double getKWD() {
            return KWD;
        }

        public double getKYD() {
            return KYD;
        }

        public double getKZT() {
            return KZT;
        }

        public double getLAK() {
            return LAK;
        }

        public double getLBP() {
            return LBP;
        }

        public double getLKR() {
            return LKR;
        }

        public double getLRD() {
            return LRD;
        }

        public double getLSL() {
            return LSL;
        }

        public double getLTL() {
            return LTL;
        }

        public double getLVL() {
            return LVL;
        }

        public double getLYD() {
            return LYD;
        }

        public double getMAD() {
            return MAD;
        }

        public double getMDL() {
            return MDL;
        }

        public double getMGA() {
            return MGA;
        }

        public double getMKD() {
            return MKD;
        }

        public double getMMK() {
            return MMK;
        }

        public double getMNT() {
            return MNT;
        }

        public double getMOP() {
            return MOP;
        }

        public double getMRO() {
            return MRO;
        }

        public double getMUR() {
            return MUR;
        }

        public double getMVR() {
            return MVR;
        }

        public double getMWK() {
            return MWK;
        }

        public double getMXN() {
            return MXN;
        }

        public double getMYR() {
            return MYR;
        }

        public double getMZN() {
            return MZN;
        }

        public double getNAD() {
            return NAD;
        }

        public double getNGN() {
            return NGN;
        }

        public double getNIO() {
            return NIO;
        }

        public double getNOK() {
            return NOK;
        }

        public double getNPR() {
            return NPR;
        }

        public double getNZD() {
            return NZD;
        }

        public double getOMR() {
            return OMR;
        }

        public double getPAB() {
            return PAB;
        }

        public double getPEN() {
            return PEN;
        }

        public double getPGK() {
            return PGK;
        }

        public double getPHP() {
            return PHP;
        }

        public double getPKR() {
            return PKR;
        }

        public double getPLN() {
            return PLN;
        }

        public double getPYG() {
            return PYG;
        }

        public double getQAR() {
            return QAR;
        }

        public double getRON() {
            return RON;
        }

        public double getRSD() {
            return RSD;
        }

        public double getRUB() {
            return RUB;
        }

        public double getRWF() {
            return RWF;
        }

        public double getSAR() {
            return SAR;
        }

        public double getSBD() {
            return SBD;
        }

        public double getSCR() {
            return SCR;
        }

        public double getSDG() {
            return SDG;
        }

        public double getSEK() {
            return SEK;
        }

        public double getSGD() {
            return SGD;
        }

        public double getSHP() {
            return SHP;
        }

        public double getSLL() {
            return SLL;
        }

        public double getSOS() {
            return SOS;
        }

        public double getSRD() {
            return SRD;
        }

        public double getSTD() {
            return STD;
        }

        public double getSVC() {
            return SVC;
        }

        public double getSYP() {
            return SYP;
        }

        public double getSZL() {
            return SZL;
        }

        public double getTHB() {
            return THB;
        }

        public double getTJS() {
            return TJS;
        }

        public double getTMT() {
            return TMT;
        }

        public double getTND() {
            return TND;
        }

        public double getTOP() {
            return TOP;
        }

        public double getTRY() {
            return TRY;
        }

        public double getTTD() {
            return TTD;
        }

        public double getTWD() {
            return TWD;
        }

        public double getTZS() {
            return TZS;
        }

        public double getUAH() {
            return UAH;
        }

        public double getUGX() {
            return UGX;
        }

        public double getUSD() {
            return USD;
        }

        public double getUYU() {
            return UYU;
        }

        public double getUZS() {
            return UZS;
        }

        public double getVEF() {
            return VEF;
        }

        public double getVND() {
            return VND;
        }

        public double getVUV() {
            return VUV;
        }

        public double getWST() {
            return WST;
        }

        public double getXAF() {
            return XAF;
        }

        public double getXAG() {
            return XAG;
        }

        public double getXAU() {
            return XAU;
        }

        public double getXCD() {
            return XCD;
        }

        public double getXDR() {
            return XDR;
        }

        public double getXOF() {
            return XOF;
        }

        public double getXPF() {
            return XPF;
        }

        public double getYER() {
            return YER;
        }

        public double getZAR() {
            return ZAR;
        }

        public double getZMK() {
            return ZMK;
        }

        public double getZMW() {
            return ZMW;
        }

        public double getZWL() {
            return ZWL;
        }

    }

}
