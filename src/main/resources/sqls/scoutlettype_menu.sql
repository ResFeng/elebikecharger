-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    VALUES ('1', '', 'sc/scoutlettype/list.html', NULL, '1', 'fa fa-circle-o');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '刷新', '/sc/outlettype/list', 'sc:outlettype:list', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '新增', '/sc/outlettype/save', 'sc:outlettype:save', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '修改', '/sc/outlettype/update', 'sc:outlettype:edit', '2', 'fa fa-circle-o';
INSERT INTO `sys_menu` (`parent_id`, `name`, `url`, `perms`, `type`, `icon`)
    SELECT @parentId, '删除', '/sc/outlettype/remove', 'sc:outlettype:remove', '2', 'fa fa-circle-o';
