package com.example.aps_appui.ui.progressTableQuery;

public interface ProgressTableQueryContract {
    interface View{
        void showCustomerList(String[] customerNames);
        void showSoIdList(String[] soId);
        void showSelectedDate(String date);
        void navigateToProgressTableDataList();
        void showName(String name);
    }
    interface Presenter{
        void onDateButtonClicked();
        void onConfirmButtonClicked();
        void onCustomerButtonClicked(String inputCustomerName);
        void loadUserData();
        void getCustomerName(String customerName, String token);
        void getSoId(String so_id,String token) ;
        void onSoIdButtonClicked(String inputSoId);
    }
    interface Model{

    }

}
