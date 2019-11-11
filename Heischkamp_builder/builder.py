import json
import sys



def make_method(header, body):
    return header+"\n{\n"+body+"\n}\n"


def make_getter_setter(varname, vartype):
    hvarname = varname.capitalize()
    s = make_method(f"public void set{hvarname}(p{hvarname})", f"this.{varname} = p{hvarname}")
    s += make_method(f"public {vartype} get{hvarname}()", f"return this.{varname}")
    return s


def make_class(classname, vars, methods):
    return "public class "+classname+"\n{\n"+vars+methods+"\n}\n"


def make_var(varname, vartype):
    return f"private {vartype} {varname};\n"


def parse_class(file):
    cj = json.load(open(file))
    vars = "".join([make_var(vname, vtype) for vtype, vname in cj["variables"]])
    gs = "".join([make_getter_setter(vname, vtype) for vtype, vname in cj["variables"]])
    return make_class(cj["classname"].capitalize(), vars, gs)
    

assert(len(sys.argv) >= 2)
cl = parse_class(sys.argv[1])
with open(sys.argv[2], "w") as f:
    f.write(cl)
