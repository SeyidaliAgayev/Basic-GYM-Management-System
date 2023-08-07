package service.impl;

import data.GlobalData;
import enums.ExceptionEnums;
import enums.StatusEnums;
import exception.EmptyList;
import exception.MemberNotFound;
import model.Member;
import service.MemberService;

import java.time.LocalDate;

import static util.InputUtil.*;
import static helper.ServiceHelper.*;

public class MemberServiceImpl implements MemberService {
    @Override
    public void register() {
        System.out.println("-------------------| REGISTER MEMBER |-------------------");

        int memberCount = requiredIntInput("How many member will be register: ");
            if (GlobalData.members == null) {
                GlobalData.members = new Member[memberCount];
                for (int i = 0; i < GlobalData.members.length; i++) {
                    memberRegisterHelper();
                }
                System.out.println(StatusEnums.MEMBER_ADDED_SUCCESSFULLY);
            } else {
                Member[] tempMember = GlobalData.members;
                GlobalData.members = new Member[GlobalData.members.length + memberCount];
                for (int i = 0; i < GlobalData.members.length; i++) {
                    if (i < tempMember.length) {
                        GlobalData.members[i] = tempMember[i];
                    } else {
                        memberRegisterHelper();
                    }
                }
                System.out.println(StatusEnums.MEMBER_ADDED_SUCCESSFULLY);
            }
            int nullMemberCount = 0;
            for (Member member: GlobalData.members) {
                if (member == null) {
                    nullMemberCount++;
                }
            }
            Member[] members = GlobalData.members;
            GlobalData.members = new Member[GlobalData.members.length - nullMemberCount];
        for (int i = 0; i < GlobalData.members.length; i++) {
            GlobalData.members[i] = members[i];
        }
    }

    @Override
    public void show() {
        if (GlobalData.members == null && GlobalData.members.length == 0) {
            throw new EmptyList(ExceptionEnums.EMPTY_LIST);
        }
        System.out.println("--------------------| ALL MEMBERS | --------------------");
        for (int i = 0; i < GlobalData.members.length; i++) {
            System.out.println(GlobalData.members[i].toString());
        }
    }

    @Override
    public void enter() {
        if (GlobalData.members == null && GlobalData.members.length == 0) {
            throw new EmptyList(ExceptionEnums.EMPTY_LIST);
        }
        boolean isEntered = false;

        System.out.println("--------------------| ENTER THE GYM | --------------------");
        int inputId = requiredIntInput("Enter the id to enter the GYM: ");
        String inputFin = requiredStringInput("Enter the FIN to enter the GYM: ");

        for (int i = 0; i < GlobalData.members.length; i++) {
            if (GlobalData.members[i].getFin().equals(inputFin)
                    && GlobalData.members[i].getNumberOfDepartures() > 0) {
                isEntered = true;
                gymTakeHelper(inputId);
                System.out.println(GlobalData.members[i].getName() + " " + GlobalData.members[i].getSurname()
                        + " - " + GlobalData.members[i].getNumberOfDepartures() + " departures left!");
            } else {
                throw new MemberNotFound(ExceptionEnums.MEMBER_NOT_FOUND);
            }
        }
        if (!isEntered) {
            System.out.println(StatusEnums.REJECTED);
        }
    }

    @Override
    public void update() {
        if (GlobalData.members == null && GlobalData.members.length == 0) {
            throw new EmptyList(ExceptionEnums.EMPTY_LIST);
        }
        System.out.println("--------------------| UPDATE DEPARTURES | --------------------");
        updateHelper();
    }
}
