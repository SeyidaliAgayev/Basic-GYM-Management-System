package service.impl;

import enums.ExceptionEnums;
import exception.*;
import service.MemberManagementService;
import service.MemberService;

import static util.MenuUtil.*;


public class MemberManagementServiceImpl implements MemberManagementService {
    MemberService memberService = new MemberServiceImpl();

    @Override
    public void memberManagement() {

        while (true) {
            int option = entryMenu();
            try {
                switch (option) {
                    case 0:
                        System.exit(-1);
                    case 1:
                        memberService.register();
                        break;
                    case 2:
                        memberService.show();
                        break;
                    case 3:
                        memberService.enter();
                        break;
                    case 4:
                        memberService.update();
                        break;
                    default:
                        throw new InvalidOption(ExceptionEnums.INVALID_OPTION);
                }
            } catch (InvalidOption | WrongFormat | LackOfDepartures | EmptyList | MemberNotFound exception) {
                exception.getMessage();
            }
        }
    }
}