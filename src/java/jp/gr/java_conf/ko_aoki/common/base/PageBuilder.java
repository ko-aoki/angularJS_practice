package jp.gr.java_conf.ko_aoki.common.base;

import java.util.ArrayList;
import java.util.List;
import jp.gr.java_conf.ko_aoki.common.base.bean.PageBean;

public class PageBuilder {

	private PageBean page;

	/**
	 * 明細のページ情報を生成します。
	 * @param curPage 現在ページ
	 * @param numByPage ページ内件数
	 * @param totalNum 全体件数
	 * @param dispPageNum 表示ページ数
	 * @return PageBean
	 */
	public PageBean build(int curPage, int numByPage, int totalNum, int dispPageNum) {
		buildBaseParts(curPage, numByPage, totalNum);
		buildDispParts(dispPageNum);

		return this.page;
	}

	private void buildBaseParts(int curPage, int numByPage, int totalNum) {

		this.page = new PageBean();
		this.page.setNumByPage(numByPage);
		this.page.setTotalNum(totalNum);

		//1未満は1
		if (curPage < 1) {
			curPage = 1;
		}

		int totalPage = (int) Math.ceil((double)totalNum / (double)numByPage);
		//合計ページより現在ページが大きかったら合計ページ
		if (curPage > totalPage) {
			curPage = totalPage;
		}
		this.page.setCurPage(curPage);

		int startNum = (curPage - 1) * numByPage + 1;
		int endNum;
		if ( (startNum + numByPage - 1) > totalNum) {
			endNum = totalNum;
		} else {
			endNum = startNum + numByPage - 1;
		}

		this.page.setStartNum(startNum);
		this.page.setEndNum(endNum);
		this.page.setTotalPage(totalPage);

		this.page.setRequestPage(this.page.getCurPage());
	}

	private void buildDispParts(int dispPageNum) {

		if (dispPageNum > this.page.getTotalPage()) {
			dispPageNum = this.page.getTotalPage();
		}

		int dispHalf = dispPageNum / 2;
		int dispHead = dispHalf;
		if (dispPageNum % 2 == 0) {
			dispHead -= 1;
		}
		int dispTail = dispHalf;
		int restHead = 0;  //前表示が少なかった場合後ろ表示を増やす
		int restTail = 0;
		int dispStartPage;
		if (this.page.getCurPage() - dispHead < 1) {
			dispStartPage = 1;
			restHead = dispHead - this.page.getCurPage() + 1;
		} else {
			dispStartPage = this.page.getCurPage() - dispHead;
		}


		int dispEndPage;
		if (this.page.getCurPage() + dispTail + restHead > this.page.getTotalPage()) {
			dispEndPage = this.page.getTotalPage();
			restTail = this.page.getCurPage() + dispTail -this.page.getTotalPage();
		} else {
			dispEndPage = this.page.getCurPage() + dispTail;
		}

		this.page.setDispStartPage(dispStartPage - restTail);
		this.page.setDispEndPage(dispEndPage + restHead);
                
                List<Integer> dispList = new ArrayList<>();
                for (int i=this.page.getDispStartPage(); i <= this.page.getDispEndPage(); i++) {
                    dispList.add(i);
                }
                this.page.setDispPageList(dispList);
	}

}
