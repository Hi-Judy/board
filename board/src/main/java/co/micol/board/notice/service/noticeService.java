package co.micol.board.notice.service;

import java.util.List;

public interface noticeService {
	//CRUD 넣기
	List <NoticeVO> noticeSelectList();
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
}
