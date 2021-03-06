package com.francetelecom.orangetv.junithistory.client.presenter.admin;

import java.util.logging.Logger;

import com.francetelecom.orangetv.junithistory.client.presenter.ClientFactory;
import com.francetelecom.orangetv.junithistory.client.presenter.PageAdminPresenter.TabAdminViewEnum;
import com.francetelecom.orangetv.junithistory.client.service.IGwtJUnitHistoryServiceAsync;
import com.francetelecom.orangetv.junithistory.client.view.admin.IAdminSubView;
import com.francetelecom.orangetv.junithistory.shared.util.ValueHelper;
import com.francetelecom.orangetv.junithistory.shared.vo.VoUserForGrid;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Presenter pour la view d'administration Users
 * 
 * @author sylvie
 * 
 */
public class TesterSubPresenter extends AbstractGridSubPresenter<VoUserForGrid> {

	private final static Logger log = Logger.getLogger("TesterSubPresenter");

	// ------------------------------------- constructor
	public TesterSubPresenter(ClientFactory clientFactory, IGwtJUnitHistoryServiceAsync service, EventBus eventBus,
			IUserSubView view) {
		super(clientFactory, service, eventBus, view);

	}

	// ---------------------------------- implementing AbstractGridSubPresenter
	@Override
	protected TabAdminViewEnum getType() {
		return TabAdminViewEnum.tabTester;
	}

	//
	@Override
	protected void doDeleteItem(int userId, IDeleteCallback callback) {

		this.rpcService.deleteTestUser(userId, new MyDeleteAsyncCallback(" when deleting tester!", callback));

	}

	@Override
	protected String[] getItemDescription(VoUserForGrid user) {
		String[] description = new String[3];

		description[0] = "NAME : " + ((ValueHelper.isStringEmptyOrNull(user.getName())) ? "undefined" : user.getName());
		description[1] = "DESCRIPTION    : "
				+ ((ValueHelper.isStringEmptyOrNull(user.getDescription())) ? "undefined" : user.getDescription());
		return description;
	}

	// ------------------------------ implementing AbstractPresenter

	@Override
	protected Logger getLog() {
		return log;
	}

	@Override
	protected void loadDatas(boolean forceRefresh) {

		this.rpcService.getListUsers(this.buildGetListCallback(" when getting list of testers."));
	}

	// ------------------------- private methods

	// ------------------------ VIEW
	public static interface IUserSubView extends IAdminSubView<VoUserForGrid> {
	}

}
