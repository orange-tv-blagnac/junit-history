package com.francetelecom.orangetv.junithistory.client.util;

import com.francetelecom.orangetv.junithistory.client.presenter.SingleReportPresenter.UploadState;
import com.francetelecom.orangetv.junithistory.client.view.IView.LogStatus;
import com.francetelecom.orangetv.junithistory.shared.TestSubStatusEnum;
import com.google.gwt.user.client.ui.Label;

public class StatusUtils {

	public static void buildTestStatus(Label label, TestSubStatusEnum subStatus) {

		String text = subStatus.getLabel();
		String styleName = CssConstants.STYLE_LABEL_TEST_STATUS + " ";

		switch (subStatus.getStatus()) {
		case Success:
			styleName += CssConstants.STATUS_TEST_SUCCESS;
			break;

		case Error:
			styleName += CssConstants.STATUS_TEST_ERROR;
			break;

		case Failure:
			styleName += CssConstants.STATUS_TEST_FAILURE;
			break;

		case Skipped:
			styleName += CssConstants.STATUS_TEST_SKIPPED;
			break;

		}

		label.setText(text);
		label.setTitle("Test status: " + text);
		label.setStyleName(styleName);
	}

	public static void buildLabelStatus(Label label, UploadState state) {

		String text = state.getText();

		String styleName = CssConstants.STYLE_LABEL_STATUS + " ";
		switch (state) {
		case started:
			styleName += CssConstants.UPLOAD_INPROGRESS;
			break;
		case done:
			styleName += CssConstants.UPLOAD_DONE;
			break;
		case canceled:
			styleName += CssConstants.UPLOAD_CANCELED;
			break;
		case error:
			styleName += CssConstants.UPLOAD_ERROR;
			break;
		case none:
			styleName += "";
			break;

		}
		label.setText(text);
		label.setTitle("upload state: " + text);
		label.setStyleName(styleName);

	}

	public static void buildLogLabel(Label label, LogStatus state) {

		if (state == null) {
			return;
		}
		String styleName = null;
		switch (state) {
		case success:
			styleName = CssConstants.STYLE_LOG_SUCCESS;
			break;
		case warning:
			styleName = CssConstants.STYLE_LOG_WARN;
			break;
		case error:
			styleName = CssConstants.STYLE_LOG_ERROR;
			break;

		}
		label.setTitle("log status: " + state.name());
		label.setStyleName(styleName);

	}

}
