package com.deploy.jenkinsdocker.proxy._static;

/**
 * 　　* @Description:
 * 　　* @param
 * 　　* @return
 * 　　* @throws
 * 　　* @author YY Shen
 * 　　* @date $ $
 *
 */
public class IUserServiceProxy implements IUserService {

    private IUserService target;

    private TxManager txManager;

    public IUserServiceProxy(IUserService target, TxManager txManager) {
        this.target = target;
        this.txManager = txManager;
    }

    @Override
    public void save(User user) {
        try {
            System.out.println(target);
            txManager.begin();
            target.save(user);
            txManager.commit();
        }catch (Exception e){
            txManager.rollback();
        }finally {
            txManager.close();
        }
    }
}
