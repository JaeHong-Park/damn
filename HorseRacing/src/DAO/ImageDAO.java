package DAO;

import java.io.File;
import java.util.ArrayList;

import DTO.EmoticonDTO;

public class ImageDAO {

	ArrayList<Object> EmoticonList;
	
	public ImageDAO() {
		EmoticonList = new ArrayList<Object>();
		
		
		EmoticonDTO edto = new EmoticonDTO();
		
		File path = new File("D:/mySample/javaNetwork/HorseRacing/images");
		
		String fileName[] = path.list();
		
		int imgIDX = 0;		// 저장되는 이미지의 인덱스 번호
		for (int i = 0; i < fileName.length; i++) {
			if (fileName[i].substring(0, 9).equals("Emo_Thum_")) {
				edto.setNumber(imgIDX);		// 인덱스 번호 저장
				edto.setThumName(fileName[i].substring(0));		// 썸네일 이미지의 파일명을 저장
				
				// 같은 번호의 gif 이미지도 저장
				int imgLenth = edto.getThumName().length();		// 썸네일 이미지의 파일명 길이를 저장
				String temp = edto.getThumName().substring(imgLenth-6, imgLenth);	// 예) 'Emo_Thum_01.png'의 '01.png'를 저장
				edto.setGifName("Emo_Play_" + temp.substring(0, 2) + ".gif");		// '01' 숫자만 연결
				
				imgIDX++;
			}
		}
		
		System.out.println(edto.getGifName());
		
//		System.out.println(fileName[1].substring(0, 9));
//		
//		int pos = fileName[0].lastIndexOf( "." );
//		String ext = fileName[0].substring( pos + 1 );
//		
//		System.out.println(ext);
	}
}
