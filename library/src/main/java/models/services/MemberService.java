package models.services;

import models.dao.DaoFactory;
import models.dao.impl.MemberDaoJ;
import models.entities.persons.Member;

import java.util.List;

public class MemberService {

    private final MemberDaoJ memberDao = DaoFactory.createMemberDao();

    public void newMember(Member member) {
        memberDao.insert(member);
    }

    public void updateMember(Member member) {
        memberDao.update(member);
    }

    public void deleteMember(String name){
        memberDao.deleteByName(name);
    }

    public Member searchMember(Integer id) {
        return memberDao.findById(id);
    }

    public Member searchMember(String name) {
        return memberDao.findByName(name);
    }

    public List<Member> listMembers() {
        return memberDao.findAll();
    }
}
