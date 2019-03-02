-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    VALUES ('1', '', 'sc/sccharge/list.html', NULL, '1', 'fa fa-circle-o');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '刷新', '/sc/charge/list', 'sc:charge:list', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '新增', '/sc/charge/save', 'sc:charge:save', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '修改', '/sc/charge/update', 'sc:charge:edit', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '删除', '/sc/charge/remove', 'sc:charge:remove', '2', 'fa fa-circle-o';
