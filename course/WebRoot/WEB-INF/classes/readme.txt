Spring的hibernate事务管理出错：
createQuery is not valid without active transaction
处理：将<prop key="hibernate.current_session_context_class">thread</prop>注释。 