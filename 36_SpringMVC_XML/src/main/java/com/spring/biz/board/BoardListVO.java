package com.spring.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 <boardList>
 	<board>
 		<seq>1</seq>
 		<title>제목1</title>
 		<writer>홍길동</writer>
 		...
 	</board>
 	<board>
 		<seq>2</seq>
 		<title>제목2</title>
 		<writer>홍길동2</writer>
 		...
 	</board>
 	<board>
 		<seq>3</seq>
 		<title>제목3</title>
 		<writer>홍길동3</writer>
 		...
 	</board>
 </boardList>
 * */

@XmlRootElement(name="boardList")
@XmlAccessorType(XmlAccessType.FIELD)//XML 변환시 필드를 엘리먼트로 설정
public class BoardListVO {

	@XmlElement(name="board") //앨리먼트(요소)의 태그명 지정
	private List<BoardVO> boardList;

	
	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
}
