package godata;

import lombok.Data;

@Data
public class GoDTO {

	private int id;
	private double lat, lng;
	private String localSpecialStNm, localSpecialStIntro, addrRoad, addrJibun;

}
