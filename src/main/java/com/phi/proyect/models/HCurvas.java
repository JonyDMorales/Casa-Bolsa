package com.phi.proyect.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="h_curvas")
public class HCurvas implements Serializable{

	@Id
	@JoinColumn(name="Cd_Curva")
	private Integer CdCurva;
	
	private String FhDate;
	private Double N1;
	private Double N2;
	private Double N3;
	private Double N4;
	private Double N5;
	private Double N6;
	private Double N7;
	private Double N8;
	private Double N9;
	private Double N10;
	private Double N11;
	private Double N12;
	private Double N13;
	private Double N14;
	private Double N15;
	private Double N16;
	private Double N17;
	private Double N18;
	private Double N19;
	private Double N20;
	private Double N21;
	private Double N22;
	private Double N23;
	private Double N24;
	private Double N25;
	private Double N26;
	private Double N27;
	private Double N28;
	
	public HCurvas() {
		super();
	}

	public Integer getCdCurva() {
		return CdCurva;
	}

	public void setCdCurva(Integer cdCurva) {
		CdCurva = cdCurva;
	}

	public String getFhDate() {
		return FhDate;
	}

	public void setFhDate(String fhDate) {
		FhDate = fhDate;
	}

	public Double getN1() {
		return N1;
	}

	public void setN1(Double n1) {
		N1 = n1;
	}

	public Double getN2() {
		return N2;
	}

	public void setN2(Double n2) {
		N2 = n2;
	}

	public Double getN3() {
		return N3;
	}

	public void setN3(Double n3) {
		N3 = n3;
	}

	public Double getN4() {
		return N4;
	}

	public void setN4(Double n4) {
		N4 = n4;
	}

	public Double getN5() {
		return N5;
	}

	public void setN5(Double n5) {
		N5 = n5;
	}

	public Double getN6() {
		return N6;
	}

	public void setN6(Double n6) {
		N6 = n6;
	}

	public Double getN7() {
		return N7;
	}

	public void setN7(Double n7) {
		N7 = n7;
	}

	public Double getN8() {
		return N8;
	}

	public void setN8(Double n8) {
		N8 = n8;
	}

	public Double getN9() {
		return N9;
	}

	public void setN9(Double n9) {
		N9 = n9;
	}

	public Double getN10() {
		return N10;
	}

	public void setN10(Double n10) {
		N10 = n10;
	}

	public Double getN11() {
		return N11;
	}

	public void setN11(Double n11) {
		N11 = n11;
	}

	public Double getN12() {
		return N12;
	}

	public void setN12(Double n12) {
		N12 = n12;
	}

	public Double getN13() {
		return N13;
	}

	public void setN13(Double n13) {
		N13 = n13;
	}

	public Double getN14() {
		return N14;
	}

	public void setN14(Double n14) {
		N14 = n14;
	}

	public Double getN15() {
		return N15;
	}

	public void setN15(Double n15) {
		N15 = n15;
	}

	public Double getN16() {
		return N16;
	}

	public void setN16(Double n16) {
		N16 = n16;
	}

	public Double getN17() {
		return N17;
	}

	public void setN17(Double n17) {
		N17 = n17;
	}

	public Double getN18() {
		return N18;
	}

	public void setN18(Double n18) {
		N18 = n18;
	}

	public Double getN19() {
		return N19;
	}

	public void setN19(Double n19) {
		N19 = n19;
	}

	public Double getN20() {
		return N20;
	}

	public void setN20(Double n20) {
		N20 = n20;
	}

	public Double getN21() {
		return N21;
	}

	public void setN21(Double n21) {
		N21 = n21;
	}

	public Double getN22() {
		return N22;
	}

	public void setN22(Double n22) {
		N22 = n22;
	}

	public Double getN23() {
		return N23;
	}

	public void setN23(Double n23) {
		N23 = n23;
	}

	public Double getN24() {
		return N24;
	}

	public void setN24(Double n24) {
		N24 = n24;
	}

	public Double getN25() {
		return N25;
	}

	public void setN25(Double n25) {
		N25 = n25;
	}

	public Double getN26() {
		return N26;
	}

	public void setN26(Double n26) {
		N26 = n26;
	}

	public Double getN27() {
		return N27;
	}

	public void setN27(Double n27) {
		N27 = n27;
	}

	public Double getN28() {
		return N28;
	}

	public void setN28(Double n28) {
		N28 = n28;
	}

	@Override
	public String toString() {
		return "Curvas [CdCurva=" + CdCurva + ", FhDate=" + FhDate + ", N1=" + N1 + ", N2=" + N2 + ", N3=" + N3
				+ ", N4=" + N4 + ", N5=" + N5 + ", N6=" + N6 + ", N7=" + N7 + ", N8=" + N8 + ", N9=" + N9 + ", N10="
				+ N10 + ", N11=" + N11 + ", N12=" + N12 + ", N13=" + N13 + ", N14=" + N14 + ", N15=" + N15 + ", N16="
				+ N16 + ", N17=" + N17 + ", N18=" + N18 + ", N19=" + N19 + ", N20=" + N20 + ", N21=" + N21 + ", N22="
				+ N22 + ", N23=" + N23 + ", N24=" + N24 + ", N25=" + N25 + ", N26=" + N26 + ", N27=" + N27 + ", N28="
				+ N28 + "]";
	}	
	
	
	
}
